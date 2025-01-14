# Using Interfaces

- Interfaces specify some conceptual similarity between different types. 

- But practically, when will you ever need an interface?
    - e.g. What if you need a function that takes in multiple types as a parameter? 
        - Problem: func foo() needs to accept 2 types, type X or type Y. How do you specify this?
        - Solution: You define interface Z, and use it as the foo() parameter. Then you let X and Y satisfy Z

- Practical example: Pool in a Yard
    - I need to put a pool in my yard. Requirements:
        - Pool needs to fit in yard. 
            - Area of pool < Total area of backyard
        - Pool needs to be fenced
            - Total perimeter must be limited
    - Problem: Need to determine a pool shape satisfies this criteria
    - Solution: Define a function `FitInYard()`
        - Takes a shape as argument and returns true if shape satisfies criteria
        - Note that `FitInYard()` must be able to accept many shape types!
        - But valid shapes must have a defined `Area()` and `Perimeter()`, to satisfy the requirements
```
type Shape2D interface {
    Area() float64
    Perimeter float64
}

type Triangle {...}
func (t Triangle) Area() float64 {...}
func (t Triangle) Perimeter() float64 {...}

type Rectangle{...}
func (r Rectangle) Area() float64 {...}
func (r Rectangle) Perimeter() float64 {...}

func FitInYard(s Shape2D) bool {
    if s.Area() < 100 && s.Perimeter() < 100 {
        return True
    }
    return False
}
```

- Empty interface is an interface that specifies no method
    - Basically means all types will satisfy this interface
    - Use when you need a function to accept any type as a parameter

```
func PrintMe(val interface{}){
    fmt.Println(val)
}
```