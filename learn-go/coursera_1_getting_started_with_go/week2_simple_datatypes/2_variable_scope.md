# Variable Scope

- Scope of a variable is place in code where variable can be accessed
    - If I reference `x`, how does the program know what you're talking about

```
var x int = 4 //variable in global scope
func f() {
    var y int = 5 // variable in local scope
    fmt.Printf("%d", x)
    fmt.Printf("%d", y)
}
func g() {
    fmt.Printf("%d", x)
    // fmt.Printf("%d", y) // will fail, because y is not in global scope
}
```

- Variable scoping is done using blocks in Go
    - A block is a sequence of declarations/statements within matching brackets {}
        - including function definitions
    - There are blocks that are implicitly defined without {}
        - Universe block: all go code
        - package block: all source in a package
        - file block: all source in a file, because a package can have many files
        - if/for/switch: all code within these statements
        - clause in switch/select: individual clauses are in their own blocks

- Lexical scoping
    - Assume 2 blocks b1 and b2. If b2 is defined inside b1, then b2 is of an inner scope
        - b1 >= b2 if b2 is defined inside b1
        - `defined inside` is transitive
    - Variable is accessible from block b2 iff
        - Variable is defined in b1
        - b1 >= b2