# Integers, Floats, Strings

- Type conversion in Go
    - Most binary operations require operands of the same type, including assignments
    - Type conversions are done with some `T()` operation, where `T` is the type desired

'''
var x int32 = 1
var y int16 = 2
x = y // will fail, because different type
x = int32(y) // will work
'''
    
- Floating points
    - float32 --> ~6 digits of precision
    - float64 --> ~15 digits of precision

```
var x float32 = 123.45 //numeric notation
var y float32 = 1.2345e2 //scientific notation
```

- Complex numbers
    - Go can also handle complex numbers

```
var x complex128 = complex(2,3)
```

- String conventions
    - ASCII: first accepted standardized code for characters. Each character is 8 bit code. Since it is 8-bit, it can only represent 2^8 unique letters (256). In actual use, it only represents 128 chars because 1 bit is used for something else
    - Unicode: 32-bit character code, can represent 2^32 characters
        - UTF-8 is variable length: 8 bit UTF8 code is the same as ascii. So first 128 codes in UTF8 is the set of ASCII characters in the same order.
    - UTF-8 is Go default
        - One `code point` is one unicode character
        - One `rune` is one `code point`
    - Strings are arbitrary sequences of bytes
        - Each byte is a rune
        - Meant to be printed
    - String literal is notated by double quotes e.g. "Hello world"

- 