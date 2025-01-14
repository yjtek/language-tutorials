# Call by reference vs Call by Value

- Call by value | Call by reference are descriptions of how arguments are passed to parameters during a function call

- Call by value
    - This means that args passed to parameters are copied to the parameters. So the data you are manipulating in the function is a copy of the original, not the original itself
    - Good: because the function does not modify any objects outside it's scope (data encapsulation)
    - Bad: because you are copying the value of the argument into the parameters, which creates heavy traffic if argument is large

```
func foo(y int) {
    y = y + 1
}

func main() {
    x := 2
    foo(x)
    fmt.Print(x) //x will still return 2, because the function has not manipulated x. It manipulated a copy of x
}
```

- Call by reference
    - Pass a pointer instead of the argument you want to pass
    - Good: No need to copy the argument, only need to copy the pointer to the argument!
    - Bad: The function is now affecting things outside its scope, not idempotent

```
func foo(y *int) {
    *y = *y + 1
}

func main() {
    x := 2
    foo(&x)
    fmt.Print(x) //x will now return 3, because the function modified the object where the pointer was referencing
}
```