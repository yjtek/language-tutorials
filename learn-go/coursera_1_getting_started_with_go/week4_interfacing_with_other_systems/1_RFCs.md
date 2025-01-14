# RFCs

- RFC = Request for comments
    - It is a standard definition of a protocol/format

- Basically, when you need to communicate with other systems, you need a standardized way of structuring this communication. RFC is a general term for such standards. Examples include:
    - HTML: Hypertext Markup Language
    - URI: Uniform resource identifier
    - HTTP: Hypertext Transfer Protocol

- Golang provides a bunch of packages that help you process these standards by default!
    - For HTTP: "net/http"
    - TCP/IP and Socket Programming: "net"
    - JSON: "json"

```
// This is a go struct
p1 := Person(name: "joe", addr: "a st.", phone: "123")

// this is the json object we want
{"name": "joe", "addr": "a st.", "phone": "123}
```