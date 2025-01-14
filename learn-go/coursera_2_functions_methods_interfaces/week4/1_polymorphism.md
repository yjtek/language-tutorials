# Polymorphism

- Ability for an object to have different forms depending on the context
    - Identical at high level of abstraction, but different at low level of abstraction
    - e.g. Area() function
        - Rectangle: Length * Base
        - Triangle: 0.5 * Base * Height

-  In traditional Object Oriented languages, polymorphism is supported by **inheritance**
    - Subclass inherits methods/data from superclass
    - Example: `Speaker` superclass, `Cat`/`Dog` subclass
        - Superclass has a `Speak()` method that prints some noise
        - Each subclass will also have a Speak() method, that prints a specific noise

- Another common pattern in object oriented languages is the ability of a subclass to **Override** methods in superclass
    - this happens when subclass redefines a method inherited from superclass
    - Hence the same `method()` signature can do different things for different objects, hence polymorphic

- Golang does NOT have inheritance
