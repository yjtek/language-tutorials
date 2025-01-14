# Garbage Collection

- In manual deallocation it can be difficult to determine when a variable is no longer in use
    - In a typical function call, once you are done with the function, the local variables will be released from memory
    - However, that will not work here, since the `foo()` function returns a pointer to x which is then used by `main()` to define y
```
func foo() *int {
    x := 1
    return &x 
}

func main() {
    var y *int
    y = foo()
    fmt.Printf("%d", *y)
}
```

- Go is a compiled langauge with automatic memory management (garbage collection)
    - Variable is dereferenced when all references to the object are gone
        - e.g. Java virtual machine + Python interpreter does the same thing
    - Go automatically allocates stuff between stack and heap memory