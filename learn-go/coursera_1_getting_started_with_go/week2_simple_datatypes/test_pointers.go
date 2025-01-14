package main

import (
	"fmt"
	"strconv"
)

func main() {
	var x int
	var y *int //If y is going to be a pointer, you need to indicate that you want the variable to be a dereferenced pointer
	z := 3
	y = &z
	x = *y
	fmt.Printf(strconv.Itoa(x) + "\n")
}
