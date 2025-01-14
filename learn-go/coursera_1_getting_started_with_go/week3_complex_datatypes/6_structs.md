# Structs

- Groups objects of arbitrary types together
- Example: I want to create a `Person` struct with 3 variables; Name, Address, Phone
    - Option 1: Have 3 separate variables that you have to manage separately 
    - Option 2: Make a single struct with all 3 vars
```
// Define a type that you can assign to variables (like int, string, etc)
type Person struct {
    name string
    addr string
    phone string
}

// Declare a variable p1 is of a Person type
var p1 Person

// Note that each property is a field and p1 contains values for all fields
```

- To access the values of a struct, use dot notation
```
p1.name = "joe" // assignment
x = p1.addr // read
```

- You can initialize structs in a few ways
```
// Option 1: Use `new` to initialise, will create an empty struct, all fields 0
p1 := new(Person) 

// Option 2: Use struct literal
p1 := Person(name: "joe", addr: "a st.", phone: "123")
```