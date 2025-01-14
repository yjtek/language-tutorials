# Comments, printing, and integers

- Comments are included by // double slash or by /* */ blocks

- Printing is done using fmt.Printf()
```
x:= "test"
fmt.Printf(x + "test2")
```

- Format strings also enabled with Printf
```
x := "test2
fmt.Printf("test %s", x)
```

- Typical initialisation of integers is simply var x int
    - However, integers have some variety (length of int + signed vs unsigned int)
        - int8, int16, int32, int64, uint8, uint16, uint32, uint64
    - Integers have a fixed set of binary operators:
        - Arithmetic
            - + - * / % << >>
            - << and >> are also called bitshift operators
            - `n << x` means n times 2, x times 
            - `n >> x` means n divided by 2, x times
        - Comparison
            - == != > < >= <=
        - Boolean
            - && ||
            
