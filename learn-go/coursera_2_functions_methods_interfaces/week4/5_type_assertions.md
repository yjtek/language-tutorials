# Type Assertions

- An interface's job is basically to conceal differences between types by highlighting the similarities
    - From the example in the last video, s.Area() and s.Perimeter() doesn't depend on the concrete type of the interface.

- But what happens when we need the interface to be aware of the underlying concrete types?
    - Now, you must expose the type differences despite the interface, which is hiding these differences

- Example: Graphics program
    - DrawShape() will draw any shape
        - func DrawShape(s Shape2D) {...}
    - But the underlying API may have a different function for each shape
        - func DrawRect(r Rectangle) {...}
        - func DrawCircle(c Circle) {...}
    - So the conundrum is; I want to use my `DrawShape()` interface which can take any argument, but inside it, I need to differentiate which function to call depending on the concrete type of s!
    - To do this, we use type assertions

```
func DrawShape(s Shape2D) {
    rect, ok := s.(Rectangle) // If s is Rectangle, rect == Rectangle, ok == True ELSE s == 0, ok == False
    if ok {
        DrawRect(rect)
    }
    tri, ok := s.(Triangle)
    if ok {
        DrawTriangle(tri)
    }
}

func DrawShape(s Shape2D) {
    switch := sh := s.(type) {
        case Rectangle:
            DrawRect(sh)
        case Triangle:
            DrawTri(sh)
    }
}
```

