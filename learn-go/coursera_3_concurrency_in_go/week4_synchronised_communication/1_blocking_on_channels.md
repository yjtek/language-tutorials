# Blocking on Channels

- Common to iteratively read from a channel
    - e.g. consumer receiving from channel and process

```
for i := range c { 
    fmt.Println(i) // Each iteration receives a new value. Iterates until sender calls close(c)
}
```

- Another common pattern is to receive from multiple goroutines
    - Multiple channels may be used to receive from multiple sources
    - e.g. T1 --c1--> T3 & T2 --c2--> T3
    - Data from both sources may be needed
```
a := <- c1
b := <- c2
fmt.Println(a*b)
```

- But in some occasions, you may read from different channels, but you don't need all of the data, just one of them!
    - Maybe data comes in from either channel c1 or c2. If you get hit with data from c1, you know you can ignore c2. 
    - So you don't want to wait on both channels!
    - Use `select` statement to wait on first data from a set of channels
```
select {
    case a = <- c1:
        fmt.Println(a)
    case b = <- c2:
        fmt.Println(b)
}
```

## Select

- So select allows you to choose from 1 of several channels, so you don't have to block on all channels (whether receiving or sending data on channel)
    - If select is given multiple blocking cases, whichever one is unblocked first will be exected
```
// Either one of these 2 cases can block! If inchan is not sending, it blocks. If nobody is receiving outchan, it also blocks!
// In this case, select simply executes which ever case is unblocked first
select {
    case a = <- inchan:
        fmt.Println("Received a")
    case outchan <- b:
        fmt.Println("sent b")
}
```

- One common use of `select` is to have a separate `abort` channel
    - Let's say you want to receive data until an `abort` is received
```
// Note that this is an infinite loop
// Here, you receive data on a from c, until a signal is received on the abort channel! 
for {
    select {
        case a <- c:
            fmt.Println(a)
        case <- abort: //Note: abort signal is not assigned. Once a signal from abort channel is received, it simply returns
            return
    }
}
```

- Another common use of `select` is to have a `default` case
    - If no case is satisfied, the whole process does not block. It simply executes the default case!
    - Basically used to avoid any blocking
```
select {
    case a = <- c1:
        fmt.Println(a)
    case b = <- c2:
        fmt.Println(b)
    default:
        fmt.Println("nop")
}
```