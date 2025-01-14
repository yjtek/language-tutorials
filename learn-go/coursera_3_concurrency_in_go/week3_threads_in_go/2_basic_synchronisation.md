# Basic Synchronisation

- Synchronisation
    - When multiple threads agree on the timing of some events
    - Use some **global events** whose execution is viewed by all threads simultaneously

- When is global event needed? When race condition met:
    - Indeterministic interleaving:
        - Task 1:
            a. x = 1
            b. x = x+1
        - Task 2:
            a. print x
        - If 1a --> 2a --> 1b then print x = 1
        - Else if 1a --> 1b --> 2a then print x = 2
    - **Global events / Synchronisation** fix the above
        - Task 1:
            a. x = 1
            b. x = x+1
            <GLOBAL EVENT>
        - Task 2:
            <IF GLOBAL EVENT>
            a. print x
        - Now, 2a will always execute after 1b

- Notice that this breaks "concurrency" 
    - Scheduler cannot interleave tasks most efficiently! 
    - So synchronisation is necessary, but will also reduce efficiency

## WaitGroups

- WaitGroups are part of the "sync" package, and are a specific type of synchronisation
    - `sync.WaitGroup` forces a goroutine to wait for other goroutines
    - Your goroutine will basically not continue until all the goroutines in the wait group complete
    - `sync.WaitGroup` contains an internal contain. You increment the counter for each goroutine to wait for, and decrement when it complete
 
```
// Main thread

var wg sync.WaitGroup
wg.Add(1) //Add 1 to counter
go foo(&wg) // wg.Done() is called from foo(), decrements counter by 1
wg.Wait() // Blocks until counter == 0

// Working example

func foo(wg *sync.WaitGroup){
    fmt.Printf("New Routine")
    wg.Done()
}
func main(){
    var wg sync.WaitGroup
    wg.Add(1)
    go foo(&wg)
    wg.Wait()
    fmt.Printf("Main routine")
}
```
