package main

import (
	"fmt"
	"strings"
)

/*

Write a program which allows the user to create a set of animals and to get information about those animals. Each animal has a name and can be either a cow, bird, or
snake. With each command, the user can either create a new animal of one of the three types, or the user can request information about an animal that he/she has
already created. Each animal has a unique name, defined by the user. Note that the user can define animals of a chosen type, but the types of animals are restricted
to either cow, bird, or snake. The following table contains the three types of animals and their associated data.

| Animal | Food eaten | Locomtion method | Spoken sound |
| --- | --- | --- | --- |
| cow | grass | walk | moo |
| bird | worms | fly | peep |
| snake | mice | slither | hsss |

Your program should present the user with a prompt, “>”, to indicate that the user can type a request. Your program should accept one command at a time from the user,
print out a response, and print out a new prompt on a new line. Your program should continue in this loop forever. Every command from the user must be either a
“newanimal” command or a “query” command.

Each “newanimal” command must be a single line containing three strings. The first string is “newanimal”. The second string is an arbitrary string which will be the
name of the new animal. The third string is the type of the new animal, either “cow”, “bird”, or “snake”.  Your program should process each newanimal command by
creating the new animal and printing “Created it!” on the screen.

Each “query” command must be a single line containing 3 strings. The first string is “query”. The second string is the name of the animal. The third string is the name
of the information requested about the animal, either “eat”, “move”, or “speak”. Your program should process each query command by printing out the requested data.

Define an interface type called Animal which describes the methods of an animal. Specifically, the Animal interface should contain the methods Eat(), Move(), and
Speak(), which take no arguments and return no values. The Eat() method should print the animal’s food, the Move() method should print the animal’s locomotion, and
the Speak() method should print the animal’s spoken sound. Define three types Cow, Bird, and Snake. For each of these three types, define methods Eat(), Move(), and
Speak() so that the types Cow, Bird, and Snake all satisfy the Animal interface. When the user creates an animal, create an object of the appropriate type. Your
program should call the appropriate method when the user issues a query command.
*/

func GetUserInput() (string, string, string) {
	var command, name, typeOrAction string
	fmt.Print("> ")
	fmt.Scanf("%s %s %s", &command, &name, &typeOrAction)
	return strings.Trim(strings.ToLower(command), " "), strings.Trim(strings.ToLower(name), " "), strings.Trim(strings.ToLower(typeOrAction), " ")
}

type Animal interface {
	Eat()
	Move()
	Speak()
}

type Cow struct{}
type Bird struct{}
type Snake struct{}

func (c Cow) Eat() {
	fmt.Println("food: grass")
}
func (b Bird) Eat() {
	fmt.Println("food: worms")
}
func (s Snake) Eat() {
	fmt.Println("food: mice")
}

func (c Cow) Move() {
	fmt.Println("move: walk")
}
func (b Bird) Move() {
	fmt.Println("move: fly")
}
func (s Snake) Move() {
	fmt.Println("move: slither")
}

func (c Cow) Speak() {
	fmt.Println("speak: moo")
}
func (b Bird) Speak() {
	fmt.Println("speak: peep")
}
func (s Snake) Speak() {
	fmt.Println("speak: hsss")
}

func main() {

	container := make(map[string]Animal, 1)
	for {
		s1, s2, s3 := GetUserInput()

		if s1 == "newanimal" {
			switch s3 {
			case "cow":
				container[s2] = Cow{}
				fmt.Print("cow in s3")
			case "bird":
				container[s2] = Bird{}
				fmt.Print("bird in s3")
			case "snake":
				container[s2] = Snake{}
				fmt.Print("snake in s3")
			}
			fmt.Println("Created it!")
			fmt.Printf("%v", container)
		} else if s1 == "query" {
			switch s3 {
			case "eat":
				container[s2].Eat()
			case "move":
				container[s2].Move()
			case "speak":
				container[s2].Speak()
			}
			fmt.Printf("%v", container)
		} else {
			fmt.Print("invalid command, only newanimal & query allowed")
		}
	}
}
