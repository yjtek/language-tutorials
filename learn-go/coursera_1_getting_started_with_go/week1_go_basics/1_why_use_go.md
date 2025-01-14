# Why use go?

- Runs fast
- Garbage collection built in
- Simpler objects compared to other languages
- Efficient concurrency

- 3 categories of languages
    - Machine language
        - Lowest level
        - Executed directly on CPU
        - Represented in binary
    - Assembly language
        - Almost 1 to 1 mapping to machine langauge, essential machine language (CPU language) with mnemonics
        - i.e. instead of 11100000, it is coded as "ADD"
    - High level languages
        - Commonly used by humans (Go, C, C++, Java, Python etc)

- All software must be translated into machine language before it can be run. This can happen in 2 ways; compiled or interpreted
    - Compilation: Translate instructions once before running the code (compilation of code prior to execution)
        - Translation only happens once (e.g. C++) 
    - Interpretation: Translate instructions while code is being run
        - Translation happens for every execution, and requires an interpreter
    - This creates a trade off
        - Compiled is faster than interpreted
        - Interpreted is much easier to use
            - manage memory automatically (what to use and what to release)
            - can infer variable types on the fly

- Go is somewhere in the middle of interpreted and compiled languages
    - It is a compiled language
    - But is able to offer garbage collection (automatic memory management)


