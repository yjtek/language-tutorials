# Slices

- Slices are basically a window on an underlying array
    - As a result, a slice can change size, up to the size of the underlying array

- Each slice has 3 properties
    - Pointer: indicates the start of slice
    - Length: number of elements in the slice
    - Capacity: Maximum number of elements in the slice

```
arr := [...]{"a","b","c","d","e","f","g"}

s1 := arr[1:3] //includes elements 1 and 2, EXCLUDING 3
s2 := arr[2:5] //includes elements 2,3,4, EXCLUDING 5
```

- Use `len()` to return length of array, and `cap()` to return capacity of array

```
a1 := [3]{"a","b","c"}
sli1 := a1[0:1]

// len of sli1 is 1. 
// cap of sli1 is 3 because the slice can go up to 3, since it starts are index 0
fmt.Printf(len(sli1), cap(sli1)) 
```

- Writing to a slice changes the underlying array, and that can affect overlapping slices that refer to the same elements

- Slice literals can be used to initialize a slice; it will create an underlying array AND a slice that references it

```
// This is a slice and not an array, because there is nothing inside the square braces while you need to define length in an array
sli1 := []int{1,2,3} 
```

