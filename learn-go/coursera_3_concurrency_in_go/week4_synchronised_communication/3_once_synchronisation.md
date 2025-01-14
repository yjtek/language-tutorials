# Once Synchronisation

- "sync" package gives you set of methods you can use to do synchronisation
    - Another useful thing is **synchronous initialisation**

- synchronous initialisation
    - Say you have a multi-routine program running, and you need to perform some initialisation task
    - An initialistion must meeting the following conditions
        - must happen once
        - must happen before everything else
    - ^these can be hard to guarantee if you have a multi-threaded program. Some possible options
        - You can just do init in the main() before calling your goroutines
        - Another way is to use `sync.Once()`

- sync.Once()
    - Has one method; `once.Do(f)`
    - You can put this in multiple goroutines, but the `once` guarantees that it only executes one time
    - All calls to `once.Do(f)` will block until the first returns
    - Hence, initialisation guaranteed to execute first, and execute only once

```
var wg sync.WaitGroup
var on sync.Once

// setup() must only be run once and run first 
func setup(){
    fmt.Println("Init")
}

func dostuff(){
    on.Do(setup)
    fmt.Println("hello")
    wg.Done()
}

// This setup will guarantee that setup() executes once and first, before dostuff()
func main(){
    wg.Add(2)
    go dostuff()
    go dostuff()
    wg.Wait()
}
```

## Deadlock

- Deadlock happens due to synchronisation dependencies
    - If you have multiple goroutines, deadlock can cause execution of different goroutines to depend on each other
    - In example below, there is dependency because G1 writes onto channel and G2 reads from channel
        - It is blocking because G2 cannot continue past the read until G1 writes.  
    - Deadlock occurs when dependencies are circular
    
```
func dostuff(c1 chan int, c2 chan int) {
    <- c1 // Wait on first channel
    c2 <- 1 // Write to second channel
    wg.Done()
}


func main(){
    ch1 :=  make(chan int)
    ch2 := make(chan int)

    // The dependency here is that DS1 is waiting for DS2 to write on ch1, so the read can occur
    // Similarly, DS2 is waiting for DS1 to write on ch2, so the read can occur
    // Both are blocking each other
    wg.Add(2)
    go dostuff(ch1, ch2) // DS1
    go dostuff(ch2, ch1) // DS2
    wg.Wait()
}
```

- The good news is that Golang runtime automatically detects deadlock 
    - `fatal error: all goroutines are asleep - deadlock!`
    - But it does not detect if only a subset of goroutines are deadlocked

## Dining philosophers problem

- "Dining philosophers" is a classic problem involving concurrency and synchronisation
    - 5 philosophers sitting at a round table, 1 chopstick is placed between each adjacent pair of philosophers
    - Everyone wants to eat their food, but you need 2 chopsticks to eat. That means that if a philosopher is eating, his neighbours can't eat
    - There are not enough chopsticks for everyone to eat at once
    - In string form, where O == philosopher and | == chopstick:
        - O | O | O | O | O | --> but circular
    - Each chopstick is a mutex (only 1 person can use chopstick at once)
    - Each philosopher is associated with a goroutine and 2 chopsticks
```
type ChopS struct {sync.Mutex}
type Philo struct {
    leftCS, rightCS *ChopS
}
func (p Philo) eat() {
    for {
        p.leftCS.Lock()
        p.rightCS.Lock()
    }
    
    fmt.Println("eating")

    p.rightCS.Unlock()
    p.leftCS.Unlock()
}

func main(){

    // Init chopsticks and philosophers
    CSticks := make([]*ChopS, 5)
    for i := 0; i < 5; i++ {
        CSticks[i] = new(ChopS)
    }
    philos := make([]*Philo, 5)
    for i := 0; i < 5; i++ {
        // Note (i+1)%5 because circular table. At philosopher 4, loops back to chopstick 0
        philos[i] = &Philo{CSticks[i], CSticks[(i+1)%5]} 
    }

    // Start dining
    // TODO: Add `wait()`s in the main
    for i := 0; i < 5; i++ {
        go philos[i].eat()
    }
}
```

- In the naive implementation above, this segment appears to be an issue:
```
p.leftCS.Lock()
p.rightCS.Lock()
fmt.Println("eating")
p.rightCS.Unlock()
p.leftCS.Unlock()
```

- We don't know what interleaving will happen
    - It is possible that the interleaving will occur when each of the 5 philosophers executes the first `Lock()`, which locks the chopstick to their left
    - Then in that state, there is no right chopsticks available for any program to grab!
    - tada, DEADLOCK!

- Dykstra's proposed fix
    - Each philosopher picks up the lowest numbered chopstick first
    - So philosopher 4 picks up chopstick 0 before chopstick 4
        - Which will block, which allows philosopher 3 to eat
    - No deadlock, but notice that philosopher 4 ends up with the lowest priority! May end up **starved**


