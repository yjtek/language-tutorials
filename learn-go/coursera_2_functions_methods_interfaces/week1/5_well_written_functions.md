# Well Written Functions

- Well written == Understandable
    - litmus test: If you want to identify a section of a code that does a specific thing, how easy is it to point out?
    - litmus test 2: if a data output is wrong, which are the parts of the code that use it and how did it go wrong?

- If something goes wrong in your code, there are 2 possibilities
    - Function is doing the wrong thing on the right data
    - Function is doing the right thing on the wrong data

- Global variables slow down debugging
    - If there are no global variables, then all inputs to the function comes from the parameters
    - In which case, the traceability is perfect, because you know what functions emitted the data
