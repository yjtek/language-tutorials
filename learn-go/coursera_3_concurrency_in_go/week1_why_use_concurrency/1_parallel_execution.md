# Parallel Execution

- Go is unique in that concurrency is built into it
    - Note: Concurrency != Parallelism

- Two programs execute in parallel if they execute at exactly the same time
    - At time t, an instruction is being performed for both processors P1 and P2
    - For parallel execution, hardware **MUST** be replicated

- Why bother with parallel execution?
    - Tasks complete more quickly, because you have more throughput
    - Note that some tasks must be sequential, so parallelism doesn't automatically lead to 2x speed. Some tasks cannot be parallelised!
        - e.g. 9 women can't give birth to 1 baby in 1 month

## Von Neumann Bottleneck

- Parallel programming is HARD. Can we get speed up without doing it?
    - Speed up processor: It used to work
        - There is a natural limit to speed as well due to **Von Neumann Bottleneck**
            - CPU need to read from memory and write to memory, and memory is always slower than CPU. So memory is bottlenecking your performance, regardless of how fast your processor is!
    - Increase processor cache memory: One way to get around the Von Neumann bottleneck is to build fast memory access onto the chip directly! 
        - Cache access time is 1 clock cycle vs main memory access ~100 clock cycle 

- Now, Moore's law has broken down
    - Failure of Moore's law, transistor density is no longer doubling every 2 years

## Power wall

- Moore's law is no longer happening. Why?

- This is because transistors consume power when they switch, and increasing transistor density increases power consumption
    - smaller transistors use less power, but density is increasing at a faster rate
    - High power leads to high temperature
    - If you have no way of cooling the chip, the entire chip will melt from the number of transistors you have

- Dynamic power
    - $ P = \alpha * CFV^{2} $
    - \alpha is % of time transistor is switching
    - C is capacitance (related to size)
    - F is the clock frequency
    - V^{2} is the voltage swing (from low to high, when transistor switches)

- Dennard Scaling
    - Voltage swing should scale with transistor size!
    - Keep power consumption and hence temperature low
    - Problem: Voltage cannot go too low, because 
        - voltage swing between low to high must exceed threshold voltage of transistor
        - Issue with random noise affecting the state of your transistors (e.g. minor eddy currents can throw off your transistors)
    - Problem: doesn't consider leakage power
        - transistor leaks off power even if it is not switching

- So instead of increasing clock frequency, they simply add cores to the chips! (hardware replication)
    - But with many cores, you need parallel execution to exploit the cores! Else there is no point in having multiple cores

