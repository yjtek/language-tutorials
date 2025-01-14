# Variadic and Deferred

- Functions can take a variable number of arguments, use ellipses to specify
    - This is treated as a slice inside the function

- Ellipses can also specify that arguments passed to a function need to be unpacked!!


```
func getMax(vals ...int) int { //here, we see an unspecified number of parameters for getMax
    maxV := -1
    for _, v := range vals {
        if v > maxV {
            maxV = v
        }
    }
    return maxV
}

func main(){
    fmt.Println(getMax(1,2,3,4)) //you can input the values into `getMax` manually 
    vslice := []int{1,2,3,4} //or you can put them into a slice and...
    fmt.Println(getMax(vslice...)) // ...pass the slice into `getMax` with the ellipses!!
}
```

- Deferred functions get executed when the surrounding function completes. Typically used for cleanup activities
    - Note that the arguments are not evaluated in a deferred manner, only the actual call is deferred

```
func main() {
    defer fmt.Println("Bye!") //prints at the end
    fmt.Println("Hello") //prints first
}

func main() {
    i := 1
    defer format.Println(i+1) //this will print 2, because i is evaluated when it is still 1, but will only print at the end of the function call

    i++
    fmt.Println("Hello")
}
```

