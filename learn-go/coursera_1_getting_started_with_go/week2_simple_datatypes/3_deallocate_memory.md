# Memory Deallocation

- All declared variables exist in memory
- When it is no longer needed, you need to deallocate these variables
    - This is to ensure memory space is made available for new stuff coming in or you will run OOM 
- In the example below, everytime you run `f()`, you need to allocate memory for instantiation of x. Without memory deallocation, x will be stored 100 times if you execute f() 100 times!
```
func f() {
    var x = 4
    fmt.Printf("%d", x)
}
```

- 2 major types of memory: Stack vs Heap 
    - Stack: primarily dedicated to function calls for local variables. Deallocated once function completes, no need for manual deallocation
    - Heap: Persistent memory; heap memory needs explicit deallocation
```
var x int = 4 // This usually uses heap memory
func f() {
    var y int = 5 // This usually uses stack memory
    fmt.Printf("%d", x)
    fmt.Printf("%d", y)
}
```
