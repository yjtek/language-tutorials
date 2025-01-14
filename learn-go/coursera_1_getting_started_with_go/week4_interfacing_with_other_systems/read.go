package main

import (
	"fmt"
	"os"
	"log"
	"bufio"
	"strings"
)

/*
Write a program which reads information from a file and represents it in a slice of structs. Assume that there is a text file which contains a series of names. Each 
line of the text file has a first name and a last name, in that order, separated by a single space on the line. 

Your program will define a name struct which has two fields, fname for the first name, and lname for the last name. Each field will be a string of size 
20 (characters).

Your program should prompt the user for the name of the text file. Your program will successively read each line of the text file and create a struct which 
contains the first and last names found in the file. Each struct created will be added to a slice, and after all lines have been read from the file, your program 
will have a slice containing one struct for each line in the file. After reading all lines from the file, your program should iterate through your slice of structs 
and print the first and last names found in each struct.
*/

func main() {

	type Name struct {
		fname string
		lname string
	}
	var filename string
	
	//byteslice := make([]byte, 0, 10)
	//holder := make([]byte, 0, 50)

	fmt.Printf("Name of file? \n")
	fmt.Scan(&filename)

	file, err := os.Open(filename)
	if err != nil {
		panic(err)
	}
	defer file.Close()

	var nameslice []Name

	scanner := bufio.NewScanner(file)
    for scanner.Scan() {
		text := scanner.Text()
		//fmt.Println(text)

		sli := strings.Split(text, " ")
        
		var n Name
		n.fname = sli[0]
		n.lname = sli[1]

		nameslice = append(nameslice, n)
    }

    if err := scanner.Err(); err != nil {
        log.Fatal(err)
    }

	for _, element := range nameslice {
		fmt.Print(element.fname + "\n")
		fmt.Print(element.lname + "\n")
	} 
}
