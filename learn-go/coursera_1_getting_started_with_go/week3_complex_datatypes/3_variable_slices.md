# Variable Slices

- So far we have talked about 2 methods to make slices
    - Make an array, then define a slice from that array
    - Use a slice literal

- `make()` function can be used to make slices, this is the 3rd way of making a slice 
    - This lets you make a slice without initialising with any values
    - You can call make(type, length) or make(type, length, capacity)

```
// Init to 0, length == capacity. Underlying array is same size as slice
sli = make([]int, 10)

// Init to 0, length != capacity. Underlying array is bigger than slice
sli = make([]int, 10, 15)
```

- `append()` function can be used to increase size of slice
    - adds elements to the end of slice
    - also inserts into underlying array, AND INCREASES SIZE OF ARRAY IF NECESSARY
    - Basically, append() will never stop appending


```
sli = make([]int, 0, 3) //Length of the slice is 0, capacity is 3
sli = append(sli, 100) //Append 100 to end of slice. Slice is now length 1, and capacity is still 3
```