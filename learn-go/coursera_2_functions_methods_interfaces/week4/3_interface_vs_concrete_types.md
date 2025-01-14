# Interfaces vs Concrete Types

- Concrete Type 
    - Specify exact representation of data and methods
    - Fully specified, complete implementation is included!!

- Interface Type
    - Just specifies method **signatures** without implementation
    - No data
    - Interfaces are eventually mapped to a concrete type

- Interface Values
    - Can be treated like other values
        - Assigned to variables
        - Passed, returned
    - Interface values have 2 components
        - Dynamic type
            - The concrete type that is gets assigned to
        - Dynamic value
            - The value of that dynamic type
        - This comes as a pair (dynamic_type, dynamic_value)

- Defining an interface type

```
type Speaker interface {Speak()}

type Dog struct {name string}

func (d Dog) Speak() {
    fmt.Println(d.name)
}

func main(){
    var s1 Speaker
    var d1 Dog("Brian")
    
    /* 
    Dog type satisfies the s1 interface! s1 is now assigned to a concrete type d1 
    s1 is a Speaker type. The `concrete type` it is assigned to is d1.
    s1's dynamic type is the `Dog` type, and the dynamic value is going to be the dog value "Brian"
    
    So this s1 speaker object is an interface, which is a pair; a dynamic type = Dog, and a dynamic value = d1
    */
    s1 = d1 

    s1.Speak()
}
```

- Interface can also have nil dynamic value. This is legal! 
    - You can still call the methods of s1 even if the dynamic value is nil

```
var s1 Speaker
var d1 *Dog

/*
d1 is NOT a concrete object, because there is no data in it
s1 has a dynamic type but no dynamic value
*/
s1 = d1

/*
Notice that you don't need a dynamic value to call `Speak()`! 
But it is best to check inside the method if the dynamic value exists, or you might run into errors
*/
func (d *Dog) Speak() {
    if d == nil {
        fmt.Println("<noise>")
    } else {
        fmt.Println(d.name)
    }
}
var s1 Speaker
var d1 *Dog

s1 = d1 
s1.Speak() // This will work, because you checked for d inside the Speak() function
```

- Nil interface value
    - This is an interface without a dynamic value AND without a dynamic type
    - In this case, you cannot call the methods in the interface

```
// Nil dynamic value and valid dynamic type --> can call method
var s1 Speaker
var d1 Dog
s1 = d1

// Nil dynamic value and nil dynamic type --> cannot call method
var s1 Speaker
```
