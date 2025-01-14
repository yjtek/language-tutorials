# File Access and os

- For more complex file access, use "os"

- Operations
    - os.Open()
    - os.Close()
    - os.Read() --> fills a []byte, you can control how much to read
    - os.Write() --> writes a []byte into a file

```
f, err := os.Open("dt.txt") // Open file first
barr := make([]byte, 10) // Make a byte array of size 10
nb, err := f.Read(barr) // pass the byte array into barr, limiting to 10 bytes. If it is called again, the next 10bytes will get read. NOT IDEMPOTENT
f.Close() // Close file
```

```
f, err := os.Create("outfile.txt") // Create file
barr := []byte{1,2,3} // Create a dummy byte slice you want to write
nb, err := f.Write(barr) // Write array to the created file
nb, err := f.WriteString("Hi") // Write some string into the file
```