# Goroutines

- Go has constructs built in to manage concurrency and threads

- Creating a Goroutine
    - One goroutine is created automatically to run main()
    - Other goroutines are created using `go` keyword

```
/*
Notice how main() blocks when running foo() i.e. a=2 doesn't run until foo() is done
*/
func main() {
    a = 1
    foo()
    a = 2
}

//VS

/*
main() is not blocked. a=2 can be run before foo( )is done
*/
func main() {
    a = 1
    go foo()
    a = 2
}
```

- Exiting a goroutine
    - Goroutine exits when code is complete
    - When main() goroutine is complete, all other goroutines are forced to exit

## Exiting Goroutines

- Early exit

```
/*
You expect to see 2 things on screen.
But if you run this, only Main Routine is printed!
Because main() completes before the other line can be printed
*/
func main() {
    go fmt.Printf("New routine")
    fmt.Printf("Main routine")
}
```

- How to prevent early exit?

```
/* 
DO NOT DO THIS, THIS IS TERRIBLE PRACTISE BECAUSE
- Your timing assumption may be wrong.
- The OS might use your downtime to schedule an entirely different thread. No guarantee it won't!
*/
func main() {
    go fmt.Printf("New routine")
    time.Sleep(999 * time.Millisecond)
    fmt.Printf("Main routine")
}
```