package main

import (
	"fmt"
	"sync"
)

func main() {

	var waitGroup sync.WaitGroup

	channel := make(chan []int, 5)

	waitGroup.Add(1)
	AddToChannel(channel)
	waitGroup.Done()

	waitGroup.Add(1)
	AddToChannel(channel)
	waitGroup.Done()

	waitGroup.Wait()
	//channel <- 3
	//channel <- 9
	close(channel)

	sli := make([]int, 0)
	for element := range channel {
		sli = append(sli, element...)
		fmt.Println(element)
		fmt.Println(sli)
	}

}
