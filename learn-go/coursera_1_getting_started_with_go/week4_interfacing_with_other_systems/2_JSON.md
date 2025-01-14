# JSON

- JSON is advantageous in a few ways
    - All unicode
    - Human readable
    - Fairly compact representation
    - Types can be recursively combined
        - Array of structs, struct in struct, etc

- JSON Marshalling

```
type struct Person {
    name string
    addr string
    phone string
}

// Marshalling a JSON 
p1 := Person(name: "joe", addr: "a st.", phone: "123")
byte_array, err := json.Marshal(p1)

// Unmarshalling a JSON 
var p2 Person
err := json.Unmarshal(barr, &p2)
```