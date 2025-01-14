# Returning Functions from functions

- Functions can return another function (i.e. function factory)
    - Can create functions with controllable parameters
    - Example: Say I want to write a function calculating distance to origin. What if I want the origin to change?
        - Option 1: Pass origin as argument
        - Option 2: Define function with new origin 
```
// Function below makes a function to calculate distance from origin, where you control the origin values
func MakeDistOrigin(o_x, o_y float64) func(float64, float64) float64 {
    fn := func(x,y, float64) float64 {
        return math.Sqrt(math.Pow(x - o_x, 2) + math.Pow(y - o_y, 2))
    }
    return fn
}
```

- Environment of a function
    - i.e. all the names defined locally in the function
    - golang is lexically scoped, so function can access variables in the block where the function is defined

- Closure: Function + its environment
    - When you pass a function as an argument, you also pass its environment along with it!!
    - This is why your `MakeDistOrigin` function is able to pass o_x and o_y to the `fn` object it creates

