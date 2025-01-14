# String Packages

- Runes are divided into many different categories
- `Unicode` package 
    - provides a set of functions to test categories of runes
        - `IsDigit(r rune)`
        - `IsSpace(r rune)`
        - `IsLetter(r rune)`
        - `IsLower(r rune)`
        - `IsPunct(r rune)`

    - Some functions provide conversions
        - `ToUpper(r rune)`
        - `ToLower(r rune)`

- `Strings` package
    - `Compare(a,b)` - returns an integer, comparing 2 strings lexicographically
        - 0 if a==b, -1 if a < b, 1 if a > b
    - `Contains(s, substr)` - Returns true if substr in s 
    - `HasPrefix(s, prefix)` - Returns true if s begins with prefit
    - `Index(s, substr)` - returns the index of the first instance of substr in s

    - Strings are immutable in Go, but modified strings are returned 
        - `Replace(s, old, new, n)` - Takes s and replaces first n instances of old with new
        - ToLower(s)/ToUpper(s) - Returns a new modified string
        - Trimspace(s) - Remove leading and trailing blank space

- Strconv pacakge
    - Provides conversions to and from string representations
    - Atoi(s) - Convert string s to int
    - Itoa(s) - Converts int(base 10) to string
    - FormatFloat(f, fmt, prec, bitSize) - convert float to string
    - ParseFloat(s, bitSize) - Convert string to float


