# Error Handling

- One common primitive interface in Go is the `Error` interface

- Many Go programs return error interface objects to indicate errors 
    - i.e. The program returns 2 values, the first being whatever they are meant to return, and the second being an error interface

```
type error interface {
    Error() string
}
```

- For most programs, if it runs correctly, error == nil. Else Error() will print the error message
    - It is idiomatic to check and handle the error after the function call

```
f, err := os.Open("something.txt")
if err != nil {
    fmt.Println(err)
    return
}
```