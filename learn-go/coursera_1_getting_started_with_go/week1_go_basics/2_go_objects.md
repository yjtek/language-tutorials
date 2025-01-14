# Objects in Go

- Go is object oriented language, but has fewer object features than other languages


- What is object oriented programming
    - Organize code through encapsulation. Related code stuff are grouped together
    - e.g. depending on what you are building, you can have a type that is specific to that domain. In the case of building a "loan scoring" application, you can have a "pax" type with some features
    - So a `type` generally has some data, and has a set of functions you can apply to the data
    - Example of object: Implementing application performing geometry in 3D
        - Overview
            - Functions that you write will operate on points
            - Each point will have some data associated with it (x,y,z coordinates)
            - Each point will also have functions (distToOrigin(), Quadrant()) etc
        - In OOO, it sounds like you should implement `Point` as a class, which defines data and functions
        - And let point1 be an object where point1 = Point(), i.e. it is an instantiation of the class

- In Go, a `class` is called a `struct`
    - `struct` is just data
    - but you can use associated methods with the struct
    - `struct` is a simplified version of class
        - No inheritance
        - No constructors (i.e. the __init__ in python classes)
        - No generics (i.e. from typing import Type // def someFunc(L: List[Type])

    
     
