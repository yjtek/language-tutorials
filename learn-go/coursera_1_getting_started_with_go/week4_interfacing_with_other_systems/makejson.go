package main

import (
	"encoding/json"
	"fmt"
	"os"
)

/*
Write a program which prompts the user to first enter a name, and then enter an address. Your program should create a map and add the name and address to the map
using the keys “name” and “address”, respectively. Your program should use Marshal() to create a JSON object from the map, and then your program should print the
JSON object.
*/

func main() {

	var name string
	var address string

	// Note that struct fields must be capitalized for it to be public, else it will not be shown!!
	type user struct {
		Name    string
		Address string
	}

	fmt.Println("Name?")
	_, err := fmt.Scan(&name)
	if err != nil {
		panic(err)
	}

	fmt.Println("Address?")
	_, err2 := fmt.Scan(&address)
	if err2 != nil {
		panic(err2)
	}

	var u1 user
	u1.Name = name
	u1.Address = address

	barr, err3 := json.Marshal(u1)
	//barr, err3 := json.MarshalIndent(u1, "", "    ")
	if err3 != nil {
		panic(err3)
	}
	os.Stdout.Write(barr)
}
