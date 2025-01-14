# Pointers

- A pointer is an address to data in memory
    - e.g. Every variable is located in memory somewhere, so a pointer is an address to that object

- 2 operators associated with pointers in Go
    - & operator: returns the address of a variable/function
        - e.g. `&someData` returns address of `someData`
    - * operator: returns data at an address (de-referencing)
        - e.g. `*someAddress` returns data at that address

```
var x int = 1
var y int

var ip *int //ip is pointer to an int, but not an actual integer

ip = &x //ip now points to the address of x
y = *ip //y is now = 1
```

- Go provides a `new()` function, which is an alternative way to create a variable
    - `new()` creates a variable and returns a pointer to that variable

```
ptr := new(int) // returns a pointer to an integer
*ptr = 3 // equate the dereference of the pointer as 3
```