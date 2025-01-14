# Variables in Go

- Naming conventions
    - Names must start with a letter
    - Names are case sensitive
    - You cannot use go keywords as a name (if, case, package, ...)

- Variables: data stored in memory
    - Must have a name and type
    - Must have a declaration 
        - e.g. `var x int` <--- Specifies a variable x of type int
        - e.g. `var x, y int` <--- Multiple definition supported
    - Must have type: defines values a variable can take and operations that can be performed on it
        - integer: integral values, with basic integer arithmetic
        - float: decimal values, floating point arithmetic
        - string: byte characters, string comparison, search etc.

- You can define an alias for a Type, for clarity if needed
    - In example below, you define a new type called Celsius, so when you declare your variable using this type later, it is more informative than a simple "float64"
```
type Celsius float64
type IDnum int

var temp Celsius
var pid IDnum
```

- All variables must be initialised before use. There are 2 ways to achieve this: 
    - Initialise in declaration
    - Initialise after declaration
    - If variables are not initialised after declaration, it will get a 0 value for its type (0 for int, 0.0 for float etc, '' for string)
```
## This initialisation is in-declaration
var x int = 100 #### Define type up front
var x = 100 #### Let compiler infer type during compilation

## This initialisation is after declaration
var x int
x = 100

## This is performing declaration and initialisation at the same time. Only for use outside a function
x := 100
```
    
    