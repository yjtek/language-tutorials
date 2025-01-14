# File Access and ioutil

- Files are accessed linearly, not randomly
    - Think of it as a casette tape, you need to mechanically turn the tape to read the next part of the file

- Basic file operations
    - open
    - read
    - write
    - close
    - seek (skip to a certain point in the file)

- For Go, multiple packages enable file access
    - "io/ioutil" is the one covered here
    - explicit open/close not needed
    - large files may cause issues

```
// dat is a []byte type
dat, e := ioutil.ReadFile("test.txt")

// Write from []byte to a file. ioutil.WriteFile requires 3 arguments: name of file, data, and unix-style permission bytes
dat = "Hello, World!"
err := ioutil.WriteFile("outfile.txt", dat, 0777)
```