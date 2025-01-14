# Arrays

- Composite data types are aggregates of other data types

- Array is a **fixed length** series of elements of a chosen type
    - i.e. how much memory is needed is known at compile time
    - Elements of an array can be accessed using subscript notation []
    - Indices start at 0
    - Elements are initialized to 0 value (or whatever the equivalent of 0 is for that type)

```
var x [5]int //indicates that x an integer array of length 5
x[0] = 2

fmt.Printf(x[1]) //will print 0, because x[1] has not been defined
```

- Array literal is a pre-defined set of values that makes up an array, can be used to initialise arrays
    - Array literal must be the same as length of array
```
var x [5]int = [5]{1,2,3,4,5} // init array to a set of values using array literal
```

- Special notation `...` for size in array literal infers the size from the number of initializers
```
x := [...]{1,2,3,4} // will infer x to be array of size 4 based on the array literal
```

- You mostly use arrays for iteration
    - Do this with `for` loop

```
x := [3]int {1,2,3}

// the object after `range` is the array we want to iterate through
// range will return the index, value at each position of the array (similar to enumerate in python)
for i,v range x { 
    fmt.Printf("ind %d, val %d", i, v)
}
```






