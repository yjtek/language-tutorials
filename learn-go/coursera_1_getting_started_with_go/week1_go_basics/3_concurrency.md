# Concurrency in Go

- Go's concurrency implementation is A+++

- Why is concurrency needed?
    - Machines have performance limits (Moore's law)
    - More transistors used to lead to higher clock frequencies, but it is getting more and more infeasible
        - Power/temperature constraints in chips, increasing clock rate --> increased heat 

- Parallelism helps mitigate this 
    - Number of cores per machine is still increasing, even as the transistor count per core is not
    - By splitting work across multiple cores, we can get things done faster

- Difficulties with parallelism
    - When do tasks start/stop?
    - What if one task needs data from another?
    - Do tasks conflict in memory?

- Concurrency is the management of multiple tasks at the same time
    - enables parallelism: 
        - management of task execution
        - communication between tasks
        - synchronization between tasks

- Go includes concurrency primitives
    - `goroutines` represent concurrent tasks
    - `channels` used to communicate between tasks
    - `select` enables task synchronization