# Interfaces

- There is no inheritance in Go. Rather, the same effect is achieved through interfaces

- An interface is a set of method signatures
    - name, parameters, return values
    - implementation is **not** defined
    - Used to express conceptual similarity between types
    - e.g. Shape2D interface
        - Must have Area() and Perimeter()

- A type **satisfies** an interface if it implements all the methods in an interface 
    - must same method signatures
    - Can have a superset of the interface methods 
    - This is basically similar to inheritance with overriding

- Defining an interface
    - Note that you don't need to state that Triangle satisfies the interface directly!

```
type Shape2D interface {
    Area() float64
    Perimeter() float64
}

// Triangle satisfies the Shape2D interface
type Triangle {...}
func (t Triangle) Area() float64 {...}
func (t Triangle) Perimeter() float64 {...}

```
