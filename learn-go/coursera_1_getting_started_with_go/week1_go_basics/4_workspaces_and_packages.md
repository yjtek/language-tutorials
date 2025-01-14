# Hierachy of directories in Go

- 3 common subdirectories
    - src: Contains source files and code
    - pkg: contains packages (libraries)  
    - bin: contains executables
    - Directory hierachy is recommended but not enforced

- Workspce directory is defined by `GOPATH` environment variable
    - Tools will assume all tools are in this path

- Packages
    - Group of related source files
    - Each package can be imported by other packages
    - Enables reuse
    
- `main` Package
    - Must have one package called `main`, which is where execution will always start
        - Compiling the `main` package generates an executable, because only this is run directly
    - Must contain a function called `main()`
    - Example below

```
package main

import "fmt"

func main() {
    fmt.Printf('hello, world \n')
}
```


    
    

