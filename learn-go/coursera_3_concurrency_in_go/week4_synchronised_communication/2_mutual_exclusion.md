# Mutual Exclusion

- Goroutines sharing variables concurrently can cause problems 
    - Because if the goroutines are writing to the same shared variable, they can interfere with each other
    - A function is **Concurrency safe** if they can be invoked concurrently without interfering with other goroutines

- Example of "bad sharing"
    - Both goroutines invoked write to `i`
    - Expectation: At the end, i = 2, so prints 2
    - BUT this doesn't always happen
    
    - Could it be because of interleavings?
        - On surface, seems reasonable, regardless of interleavings
        - Regardless if task 1 or task 2 executes first, i just increments
    
    - The above is a trap! There is a lot more interleaving than what we are seeing on the surface
        - Interleaving occurs at machine code, not source code
        - So what gets interleaved is the underlying machine code instructions
        - The interleaving of machine code instructions can chop up your go source code instructions
        - Take i = i + 1. This is 3 steps in machine code
            - read i
            - increment
            - write i
    
    - So where does this go wrong? A few ways:
        - e.g. This goes wrong when the `read i` task gets run by task 1, and gets interleaved with `read i` in task 2
        - Both tasks have read i as 0
        - So when you increment and write back to i, i will simply be 0!
```
var i int = 0
var wg sync.WaitGroup

func inc() {
    i = i + 1
    wg.Done()
}

func main(){
    wg.Add(2)
    go inc()
    go inc()
    wg.Wait()
    fmt.Println(i)
}
```

## Mutex

- So how do we do data sharing correctly? i.e. don't let multiple goroutines write to the shared variable at the same time
    - Need to restrict possible interleavings at machine code level i.e. access to shared variables canot be interleaved
    - This is done by **mutual exclusion**
    - code segments in different goroutines that cannot execute concurrently
    - So writing to shared variables should be mutually exclusive

- Sync.Mutex
    - ensures mutual exclusion through a binary semaphore
        - if flag is up, means shared variable is in use; else if down, not in use

## Mutex methods

- We have discussed semaphores in Mutex. These are implemented using some sync.Mutex methods
    - `Lock()`: puts flag up, shared variable in use
        - If flag is up, and another goroutine comes in and tries to `lock` the variable, the `Lock()` function blocks the second goroutine from accessing the data
    - `Unlock()`: puts flag down
        - Done using shared variable
        - One of the goroutines that were previously blocked by `Lock()` will now be able to call `Lock()` on the shared variable

```
var i int = 0
var mut sync.Mutex
func inc() {
    mut.Lock()
    i = i + 1
    mut.Unlock()
}
```
