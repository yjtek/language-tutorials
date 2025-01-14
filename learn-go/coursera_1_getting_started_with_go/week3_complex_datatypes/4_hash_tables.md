# Hash Tables

- Contains key/value pairs (equivalent to python's dict)
    - e.g. GPS Coordinates + Address

- Each value is associated with a unique key, and a hash function is used to compute the slot for the key

- Think of a hash table as a big array, with many slots
    - There is a hash function that takes the value of the key, and outputs the position in the array it will slot the value into
    - Hash function is not explicitly called

- Advantages of hash table
    - Faster lookup than list
        - O(1) lookup for hash table, O(n) for list
    - Arbitrary keys
        - Not ints, like slices or arrays
- Disadvantages of hash table
    - May have hash collision
        - Two keys may hash to the same slot
        - Collisions are rare, but slow down lookup when it happens

