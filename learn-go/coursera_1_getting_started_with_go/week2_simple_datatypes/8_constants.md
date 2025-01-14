# Constants

- Constants are expressions whose values are known at time of compilation
- Type is inferred from RHS of the assignment

```
const x = 1.3
const (
    y = 4
    z = "Hello"
)
```

- `iota()` is a function used to generate set of related but distinct constants
    - Basically one hot encoding lol
    - Constants must be different but the order is not impt
    - Basically an `enum` type in other languages

```
type Grades int
const (
    A Grades = iota //iota will assign value to this constant, and each of the following constants
    B
    C
    D
    F
)
```


