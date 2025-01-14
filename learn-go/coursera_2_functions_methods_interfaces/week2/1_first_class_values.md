# First-class Values

- Functions are first-class values in Go
    - This means that you can treat a function as any other type (int type, string type etc).
        - Anything you can do to a type, you can do to a func
        - e.g. you can declare a variable to be an int, string, or a function!
    - Functions can be created dynamically
        - e.g. you can do x := 3 when running the code
        - You can also do that with functions!
    - Functions can be passed as values to other functions, and be returned from another function, and can be stored in a data structure

- Declaring variables as functions

```
/* 
Declare var `funcVar` as a function that takes an int as argument, and returns an int 
This is also known as a function signature
*/
var funcVar func(int) int 

// Declare an actual function using the signature
func incFn(x int) int {
    return x + 1
}

func main() {
    funcVar = incFn // Simply define funcVar as equal to an incFn
    fmt.Print(funcVar(1))
}
```

- Using functions as arguments

```
// Example 1: applyIt takes in a function with a int argument and returns an int, and applies it to another int
func applyIt(afunct func(int) int, val int) int {
    return afunct(val)
}

// Example 2: 

func applyIt(afunct func(int) int, val int) int {
    return afunct(int)
}

func incFn(x int) int {return x+1}
func deccFn(x int) int {return x-1}

func main() {
    fmt.Println(applyIt(incFn, 2))
    fmt.Println(applyIt(decFn, 2))
}
```

- Functions don't necessarily need a name (anonymous functions)

```
func applyIt(afunct func(int) int, val int) int {
    return afunct(val)
}

func main() {
    v := applyIt(func(x int) int {return x+1}, 2) // You can just define the function as a lambda function directly! 
    fmt.Println(v)
}
```