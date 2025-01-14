# Passing arrays and slices

- Say you want to pass an array into the functions. If your array is big, running the func is going to incur a huge copy if you do a call by value

```
func foo(x [3]int) int {
    return x[0] + 1
}

func fooPointer(x *[3]int) int {
    return (*x)[0] + 1
}

func main() {
    a := [3]int{1,2,3}
    fmt.Print(foo(a)) // Memory intensive, copies the whole of array a into parameter x, but does not modify a

    fmt.Print(fooPointer(&a)) // Memory light, only copies the pointer, but a is changed
}
```

- The above approach of using pointers and dereferences work, but can get messy. In general, if you want to pass arrays around in Go, the equivalent way is to use a slice
    - This is because a slice is basically a pointer, with a length and capacity value. 
    - Basically you get the pointer bit for free, and it is more idiomatic

```
func foo(sli int) int {
    sli[0] = sli[0] + 1
}

func main(){
    a := []int{1,2,3}
    foo(a)
    fmt.Print(a)
}
```