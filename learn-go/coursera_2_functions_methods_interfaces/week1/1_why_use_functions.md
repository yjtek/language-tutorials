# Functions basics

- Same as python, it is a set of instructions with a name
    - Sometimes, the name is not even necessary

```
func main(){
    fmt.Printf("Hello, world.")
}
```

- main() is what gets called by default when you do a `go run` in cmd line. else, you need to call the functions explicitly for stuff to be run

```
func PrintHello(){
    fmt.Printf("Hello, world")
}

func main(){
    PrintHello()
}
```

- Function declarations in Go are done in the format `func <name>(args) <return valules> {}`