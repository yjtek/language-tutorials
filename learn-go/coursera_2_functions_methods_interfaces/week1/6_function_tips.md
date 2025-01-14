# Guidelines for functions

- Well named functions and parameters

```
func ProcessArray(a []int) float {
    ...
}

// compared to...

func ComputeRMS(samples []float) float {
    ...
}
```

- Functional cohesion: function should only perform 1 operation
    - what is an "operation" depends on the context

```
// Example: Geometry

PointDist()
DrawCircle()
TriangleArea()
```

- Few parameters: It is much harder to trace many parameters than a few
    - If you find that you have functions that require a huge number of parameters, chances are you have written a function with bad cohesion
    - This is because your function is probably doing many unrelated things, which can be separated into several functions cleanly

- Group related arguments into structures
    - e.g. TriangleArea()
        - Bad solution: To compute this, you need 3 points, each points has (x,y,z) parameters. So this function takes in 9 params
        - Better solution: Define a new type `Point` that is a struct, with x,y,z as float, and let TriangleArea() take in 3 `Point`
            - type Point struct {x,y,z float}
        - Best solution: Define a new type called `Triangle` that takes in 3 `Points`. Then pass the Triangle type into the function

- Function length should be constrained
    - function call hierachy: instead of 1 function of 100 lines, chop it into 2 logical functions of 50 lines

- Control flow complexity
    - every `if` branches your control flow path. So the more conditionals you have, the worse your control flow complexity

```
// 3 paths, but complex!
func foo() {
    if a == 1 {
        if b == 1 {
            ...
        }
        ...
    }
    ...
}

// Instead, try this. Separate the conditionals, so each function is less complex!
func foo() {
    if a == 1 {
        CheckB()
    }
    ...
}

func CheckB() {
    if b == 1 {
        ...
    }   
}


```
        
