# Classes and Encapsulation

- Classes are a large part of Object Oriented programming
    - A class is basically a collection of datafields and functions that share a well defined responsibility
    - e.g. Point class 
        - will have some collection of (x,y,z) coordinate values 
        - set of functions that are relevant to its manipulation e.g. DistToOrigin(), Quadrant() etc
    - A class is a template
    - Contains data fields, not data

- An object is an instantiation of a class

- Encapsulation: The act of hiding data from programmers, such that you can only access them by using methods in the class
    - You don't usually trust the programmer not to do something stupid
    - e.g. I want to double distance to origin
        - Option 1: Make method DoubleDist() --> encapsulation!
        - Option 2: Trust programmer to double X and Y directly
