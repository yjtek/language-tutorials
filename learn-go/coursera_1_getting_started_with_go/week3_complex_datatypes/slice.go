package main

/* 
Write a program which prompts the user to enter integers and stores the integers in a sorted slice. The program should be written as a loop. 
Before entering the loop, the program should create an empty integer slice of size (length) 3. During each pass through the loop, the program 
prompts the user to enter an integer to be added to the slice. The program adds the integer to the slice, sorts the slice, and prints the contents 
of the slice in sorted order. The slice must grow in size to accommodate any number of integers which the user decides to enter. The program should 
only quit (exiting the loop) when the user enters the character ‘X’ instead of an integer.
*/

import (
	"fmt"
	"sort"
)

func main() {

	sli := make([]int, 3)
	var inputInt int
	
	//for ok := true; ok; ok = (inputInt != "X") {
	for {
		
		fmt.Printf("input any integer \n")

		_, err := fmt.Scan(&inputInt)

		if string(inputInt) == "X" || err != nil {
			break
		}

		sli = append(sli, inputInt)
		sort.Ints(sli)
		fmt.Printf("%v", sli)

	}
}


