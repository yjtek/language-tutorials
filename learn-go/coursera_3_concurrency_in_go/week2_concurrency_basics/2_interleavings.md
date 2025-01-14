# Interleavings

- One major difficulty of writing concurrent code is having a mental model of the code's state at a given time
    - In typical code, if something crashes, you know which line it crashes at
    - In concurrent code, it may crash in line X in task 1, But what about other tasks? System state can differ at the point of each crash!

- Interleavings: Instructions in 2 different tasks
    - Task 1: 
        - a = b + c
        - d = e + f
        - g = h + i
    - Task 2:
        - r = s + t
        - u = v + w
        - x = y + z
    - Order of execution within task is known, but between tasks is unknown; there are many ways that these 2 tasks can be interleaved with one another. Ordering is non-deterministic
    - You must consider all combinations to debug the program

## Race conditions

- Race condition is a problem that can happen as a result of these interleavings
    - i.e. The outcome of the programme depends on the interleaving
    - e.g.
        - Task 1:
            a. x = 1
            b. x = x+1
        - Task 2:
            a. print x
        - If 1a --> 2a --> 1b then print x = 1
        - Else if 1a --> 1b --> 2a then print x = 2

- Such things happen because of communication between tasks (in example above, the variable x)

- Communication between tasks
    - Threads of largely independent, so it largely avoids race conditions
    - But they are never completely independent, because multiple threads are probably sharing some common information
    - e.g. web server --> one thread per client, but client may need to send data back to webpage
        - for example, buying tickets! Different pax are largely independent, but not completely