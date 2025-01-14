# Concurrent vs Parallel

- As mentioned before, concurrent != Parallel

- Concurrent is not necessarily executing at the same time
    - 2 tasks are concurrent if start time and end time of the tasks overlap
    - Parallel tasks must be executed on different hardware, concurrent tasks do not
    - Mapping of tasks to hardware (parallelism) is not necessarily controlled by the programmer
        - At least not in Go and most common languages

- In concurrent programming
    - Programmer determines which tasks **can be** executed in parallel 
    - Mapping tasks to hardware will determine what **will be** executed in parallel. It depends on:
        - operating system
        - go runtime scheduler

- You might ask; if concurrent execution isn't parallel, then what is the benefit? Isn't it simply sequential execution by another name?
    - Suppose you have only 1 Core. Is there even value in concurrent programming?
    - Yes!
    - Latency hiding
        - Tasks typically must periodically wait for something
            - e.g. if your task needs some memory call, or communicate with something on network
            - e.g. X = Y + Z --> need to access Y and Z from memory 
        - Concurrency can hide this latency (i.e. while task 1 is waiting for high latency step, task 2 executes etc)

- Hardware mapping in Go
    - Programmer does not determine hardware mapping, only define what parallelism is possible
    - Because hardware mapping depends on underlying hardware architecture, and you don't generally care
        - Else you need to know if your data is in local cache? Shared cache? In hard disk? 
