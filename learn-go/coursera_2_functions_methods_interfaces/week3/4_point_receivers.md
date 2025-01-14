# Point Receivers

- We've talked about using receiver types to construct "classes" in Go
    - Recall that this way of defining methods implicitly passes the receiver object into the method (pass by value)
        - i.e. in the previous set of notes, `p.InitMe(3,4)` implicitly passes the object `p` into the `InitMe` method

- Since the argument is passed by value, method cannot modify data inside the receiver!!

```
func main(){
    p1 := Point(3,4)
    p1.OffsetX(5) // Will not modify p1!!
}
```

- Also, due to pass by value, a huge copy operation is incurred if the receiver is large

```
type Image[100][100]int

func main(){
    i1 := GrabImage()
    i1.BlurImage() //100*100 values are copied into BlurImage()
}
```

- So instead of writing these methods with receiver objects, we simply write it with `pointer receivers`  
    - Same idea as functions. Instead of passing objects, you pass the pointer to the object!

```
func (p *Point) OffsetX(v float64){ //p is a pointer, not a `Point` object! Now you can modify the `Point`
    p.x = p.x + v
}
```

- Note that by using a pointer receiver, there is no need to reference of dereference the pointer in the method!

```
func (p *Point) OffsetX(v int){
    p.x = p.x + v
    // *p.x = *p.x + v  <-- Dereference is not needed!
}

func main() {
    p := Point(3,4)
    
    p.OffsetX(5) 
    // &p.OffsetX(5) <-- Reference is also not needed!
}
```

- It is good practise to stick to 1 convention; either all methods use pointer receivers, or all methods use non-pointer receivers
    - Pointers should be preferred, because this allows modification