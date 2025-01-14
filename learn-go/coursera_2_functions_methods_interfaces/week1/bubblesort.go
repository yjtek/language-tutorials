package main

import (
	"fmt"
	"strings"
	"strconv"
)

/*
Write a Bubble Sort program in Go. 

The program should prompt the user to type in a sequence of up to 10 integers. 
The program should print the integers out on one line, in sorted order, from least to greatest. 

As part of this program, you should write a function called BubbleSort() which takes a slice of integers as an argument and returns nothing. 
The BubbleSort() function should modify the slice so that the elements are in sorted order.

A recurring operation in the bubble sort algorithm is the Swap operation which swaps the position of two adjacent elements in the
slice. You should write a Swap() function which performs this operation. Your Swap()
function should take two arguments, a slice of integers and an index value i which
indicates a position in the slice. The Swap() function should return nothing, but it should swap
the contents of the slice in position i with the contents in position i+1.

Submit your Go program source code.
*/

func Swap(intslice []int, j int) {
	intslice[j], intslice[j+1] = intslice[j+1], intslice[j]
}

func BubbleSort(intslice []int) {
	for i := 0; i < len(intslice) - 1; i++ { //-1 because the last element has nothing to compare to for the swap
		for j := 0; j < len(intslice) - i - 1; j++ {
			if intslice[j] > intslice[j+1] {
				Swap(intslice, j)
			}
		}
	}
}

func main() {

	var intstr string
	fmt.Print("Type a sequence of up to 10 comma separated Integers \n")
	fmt.Scan(&intstr)

	strslice := strings.Split(intstr, ",")
	intslice := make([]int, len(strslice))

	for index, element := range strslice {
		intslice[index], _ = strconv.Atoi(element)
	}

	BubbleSort(intslice)

	fmt.Printf("%v", intslice)
}
