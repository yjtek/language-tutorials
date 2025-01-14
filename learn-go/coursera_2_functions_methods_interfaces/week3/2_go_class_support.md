# Support for Classes in Go

- Go has no `class` keyword, but you can achieve something similar

- Basically, in Go, you can associate methods with data (which is what a class is for anyway) by using something called a **receiver type**
    - Method has a receiver type it is associated with
    - Use dot notation to call method
    - Some things to note
        - You can't associate method with existing types
        - Type must be defined in the same package as the method you're associating it with

```
type MyInt int // Define some new type

func (mi MyInt) Double () int ( //Associating `Double` with MyInt types! `mi` is a representation of the MyInt object 
    return int(mi*2)
)

func main(){
    v := MyInt(3)
    fmt.Println(v.Double())
}
```

- In the block above, notice something interesting. `Double()` looks like it takes no arguments, but you are basically passing the `mi MyInt` object into double as an **implicit argument**
    - It is passed by value

- So far, we have only looked at using a simple type as a receiver type. But it is far more common to use more complex data types as receiver types (e.g. structs)
    - This is also closer to the usual way we work with classes, with multiple types of data smushed together in 1 object

- Associating a struct with multiple methods simply gives us what we would usually call a `class` in other languages

```
func (p point) DistToOrigin() {
    t := math.Pow(p.x, 2) + math.Pow(p.y, 2)
    return math.Sqrt(t)
}

func main() {
    p1 := Point(3,4)
    fmt.Println(p1.DistToOrigin())
}
```