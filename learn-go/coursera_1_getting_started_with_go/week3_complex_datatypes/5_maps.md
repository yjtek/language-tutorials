# Maps

- Map is Go's implementation of a hash table

- Use make() to create a map

```
var idMap map[string][int] // declare a map variable, with string keys and int values
idMap = make(map[string]int) // actually instantiate the map as empty map
```

- Creating a map: Like arrays and slices, you can instantiate a `map` with a map literal

```
idMap := map[string]int {
    "joe": 123
}
```

- Accessing elements in a map: To access elements in maps, just do it as you would an array, except input the element key instead of element index. Zero will be returned if not presents

```
fmt.Println(idMap["joe"])
```

- Adding a key/value pair in a map

```
idMap["jane"] = 456
```

- Deleting a key/value pair

```
delete(idMap, "joe")
```

- Two value assignment; you can assign 2 values in 1 assignment line. The first value returns the value at the given key, and the second is a boolean that returns true if key is present in the map
```
value_of_joe, boolean_if_key_present := idMap["joe"]
```

- len() of map will tell you how many key-value pairs are in the map
```
fmt.Println(len(idMap))
```

- Iterating through the map
```
for key,val := range idMap {
    fmt.Println(key, val)
}
```
