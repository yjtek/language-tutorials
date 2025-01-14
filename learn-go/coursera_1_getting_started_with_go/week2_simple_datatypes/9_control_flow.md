# Control Flow

- if
```
if x > 5 {
    fmt.Printf("Hello")
}
```

- for
```
// Example 1: For statements have this template structure: for initialisation; condition; update {...}
for i:=0; i<10; i++ {
    fmt.Printf("hello")
} 

// Example 2: But it is also possible to just write the condition, and manually set the initialisation and update
i = 0
for i < 10 {
    fmt.Printf("Hi")
    i++
}

// Example 3: Infinite loop
for {
    fmt.Printf("hello")
}
```

- switch
    - Multi-way if statement (i.e. case when, if elif elif etc)
        - Switches contains a tag, which is a variable to be checked
        - Tag is compared to a constant defined in each `Case`
        - Case that matches the tag is executed

```
switch x {
    case 1:
        fmt.Printf("case1")
    case 2: 
        fmt.Printf("case2")
    default:
        fmt.Printf("case3")
}
```