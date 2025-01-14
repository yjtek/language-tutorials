# Function Parameters and Return Values

- Parameters are listed in parenthesis after the function name
- Arguments are supplied in the function call

```
func foo(x int, y int) { //params declared here
    fmt.Print(x * y)
}

func main(){
    foo(2,3) //arguments given here
}
```

- You can list arguments of the same types together

```
func foo(x, y int) { //params declared here
    fmt.Print(x * y)
}
```

- Functions can also have typed return values, which goes after the parameters in the declaration. 
- Can have multiple typed return values as well

```
func foo(x int) int { //params declared here + return type declared 
    return x + 1
}
y := foo(1)

func foo2(x int) (int, int) { //params declared here + 2 return types declared 
    return x, x + 1
}
y, z := foo2(1)

```