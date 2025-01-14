# Control Flow & Scan

- Tagless Switch
    - Typically, a switch will have a `tag`, which is basically the value you use to compare against conditional statements, to see which case you want to execute
    - But it also is possible to have a switch wthout a tag; the switch will simply execute the first case where the conditional evaluates to be true
    - In this example, case will contain an expression that resolves to a boolean 

```
switch {
    case x > 1:
        fmt.Printf("case1")
    case x < -1:
        fmt.Printf("case2)
    default:
        fmt.Printf("nocase")
}
```

- Break and continue
    - Break/continue exist for use in loops
    - Break exits the loop when it is hit
    - Continue skips the current iteration of the loop, but won't break you out of it 

```
// Example 1
i := 0
for i < 10 {
    i++
    if i == 5 { break } //loop stops when i == 5
    fmt.Printf("Hello")
}

// Example 2
i := 0
for i < 10 {
    i++
    if i == 5 { break } //loop skips when i == 5, but will print for 6, 7 etc.
    fmt.Printf("Hello")
}
```

- Scan
    - Scan will force user to input something, then take user input and put it into whatever pointer you provided 
    - Returns number of scanned items

```
var appleNum int
fmt.Printf("Number of apples you want?")

num, err := fmt.Scan(&appleNum) // Note that you provided a pointer to the variable, not the variable itself (because it has not been initialised!!)

// Let's say user types in 5. Scan will take the 5 and place it in the address of appleNum

fmt.Printf(appleNum)

```