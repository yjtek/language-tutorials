# Communication

- Goroutine communication is important because these goroutines mostly work together to complete some task
    - Often, these independent threads need to send data to each other to collaborate
    - e.g. Find product of 4 integers
        - make 2 extra goroutines, each multiplies a pair, then each will send their results back to main(), which multiplies the 2 numbers and returns
        - need to send data from main to sub-routines and vice versa 

- `channels` are used to transfer data between goroutines!
    - channels are typed 
    - like `map`, use `make()` to create a channel
    - use arrow operator to send and receive data on channel

```
c := make(chan int)
c <- 3 // send data to channel
x := <- c  //  get data from channel

// Example
func prod(v1 int, v2 int, c chan int) {
    c <- v1 * v2
}
func main(){
    c := make(chan int)
    go prod(1,2,c)
    go prod(3,4,c)
    a := <- c // get first thing out of channel
    b := <- c // get second thing out of channel
    fmt.Println(a*b)
}
```

## Blocking on channels

- A channel is unbuffered by default
    - Unbuffered channel cannot hold data in transit
    - Implication is that sending has to block until data is received, and the receive has to block until data is sent
    - Notice when you use channels like this, channels are enabling communication, BUT also doing synchronisation!
        - Because task 1 has to wait for task 2 to receive/send 

```
// Task 1: Channel cannot hold data, so it needs to block for 1 hr until task 2 receives!
c <- 3

// 1hr later, task 2: Channel cannot hold data, so it needs to block until task 1 sends
x := <- c
``` 

- Blocking and Synchronisation
    - channel communication is synchronous
    - blocking is the same as waiting for communication

```
// Task 1: send data to channel
c <- 3

// Task 2: You're not actually storing the data, BUT because of the blocking behaviour, task 2 waits for task 1 to send. So
// this is the equivalent of having a waitgroup!
<- c 
```

## Buffered channels

- So far, we have looked at default unbuffered channels
    - But channels CAN have a buffer (i.e. have some **capacity**)
    - c := make(chan int, 3) <-- make channel with buffer size 3

- For channel with buffer, it only blocks if buffer is full!
    - In channel `c` above, you can do 3 sends without blocking, because buffer can hold stuff and allow goroutine to continue execution
    - Similarly, you can do 3 receives without any sends

```
Note: imagine c has buffer size 1

// Task 1
c <- 3

// Task 2: first receive blocks until send occurs. Second receive blocks forever, because there is no send
a := <- c
b := <- c
```

```
// Task 1: If receive has happened, then second send writes into buffer and does not block
// If the receive has not happened, then second send will block until receive happens
c <- 3
c <- 4

// Task 2
a := <- c
```

- Why use buffering?
    - So sender and receiver don't need to operate at the same speed as long as average speed is the same
    - If no buffer, sender and receiver need to be lockstep!
    - Imagine you have a data producer and data consumer. Without a buffer, any delay in data consumption will lead to producer data getting dropped, which is not desirable