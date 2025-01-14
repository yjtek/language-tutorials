# Go tool

- `import`: keyword used to access other packages
    - Go includes many built in packages (e.g. fmt)
    - When import is called, it searches directories specified by `GOROOT` and `GOPATH`
        - If package is elsewhere, you need to change the `GOROOT` and `GOPATH` env variables

- Go tool
    - tool used to manage Go sourcecode (i.e. your command line stuff)
    - Examples
        - `go build`
            - compiles the program, argument can be a list of packages or list of .go files
            - if not specified, it will run the main.go file in the directory you're currently in
        - `go doc`
            - prints documentation for a package
        - `go fmt`
            - format source code files
        - `go get`
            - download packages and installs them
        - `go list`
            - lists all installed packages
        - `go run`
            - Compiles go file and runs the executables
        - `go test`
            - runs tests using files ending in "_test.go"
