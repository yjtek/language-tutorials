# Processes

- Take a computer as an example. It runs many things at the same time (concurrently)
    - This multitasking is enabled by the operating system
    - Basically it enables you to have multiple processes running concurrently

- A process is an instance of a running program. Each process has some things unique to it collectively called a context:
    - Memory: Virtual address space
        - Code, Stack, Heap, shared libraries
    - Registers: Tiny super fast memories (just store 1 value)
        - Program counter (what program are you executing now, and what next)
        - Data registers
        - Stack pointer   

- Operating system: allow many processes to run concurrently
    - OS needs to make sure every process gets fair use of the resources
    - Processes are switched quickly (~20ms)
    - This is collectively called "scheduling"

## Scheduling

- Scheduling Processes
    - OS schedules processes for execution
    - Some processes are higher priority, and the OS will have to handle the resource access between conflicting prioritisations

- Context switching: This is what happens when an OS moves from one process to another
    - You need to take the current state (context) of A and save it somewhere for later use
    - Then you bring in the state of process B that you previously saved

## Threads and Goroutines

- Threads vs Processes
    - At the beginning of time, there were only processes
    - However, one downside of processes is that context switching time is long, because it needs a lot of memory access to re-instate the context of each task
    - To speed up the switching process, **threads** were invented

- Threads 
    - Threads share some context, and many threads can exist in 1 process
    - Think of a thread as a mini-process, it has all the components of a process (memory, context etc), just less
    - So context swtching between processes is long, because the context is large, but context switching betwen threads is much faster
    - So now, instead of scheduling processes, OS schedule threads 

- Goroutine
    - So goroutines are like sub-threads within Go
    - Many Goroutines execute within a single OS thread
    - Go switching between goroutines within a single OS thread using the Go runtime scheduler
    - Go runtime scheduler uses some logical processor, which is mapped to a thread. Typically, 1 logical processor is mapped to an OS thread, and the goroutine runs on that processor.
    - Since the Goroutines are all running in a single OS thread, there is no opportunity for actual parallelism; it is all concurrent
    - BUT what you CAN do is, instead of using a single logical processor, you can invoke multiple logical processors
    - When you do this, the Go runtime scheduler will take these Goroutines and map them to different processors, which can be mapped to a different system thread, which can then be mapped to different cores