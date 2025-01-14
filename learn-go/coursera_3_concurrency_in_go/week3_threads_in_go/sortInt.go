package main

import (
	"bufio"
	"fmt"
	"io"
	"os"
	"sort"
	"strconv"
	"strings"
	"sync"
)

/*
Write a program to sort an array of integers. The program should partition the array into 4 parts, each of which is sorted
by a different goroutine. Each partition should be of approximately equal size. Then the main goroutine should merge the
4 sorted subarrays into one large sorted array.

The program should prompt the user to input a series of integers. Each goroutine which sorts ¼ of the array should print
the subarray that it will sort. When sorting is complete, the main goroutine should print the entire sorted list.
*/

func sortSlice(s []int) []int {
	sort.Sort(sort.IntSlice(s))
	return s
}

func SortAndAddToChannel(s []int, c chan []int) {
	sorted := sortSlice(s)
	c <- sorted
}

func scanString(s *bufio.Scanner) (string, error) {
	if s.Scan() {
		return s.Text(), nil
	}
	err := s.Err()
	if err == nil {
		err = io.EOF
	}
	return "", err
}

func UserInputToSlice() []int {
	//var userInput string
	fmt.Println("Please input a space separated string of integers to sort")
	s := bufio.NewScanner(os.Stdin)
	userInput, _ := scanString(s)

	stringsli := strings.Split(userInput, " ")
	intsli := make([]int, len(stringsli))
	for index, element := range stringsli {
		//intval, _ = strconv.Atoi(element)
		intsli[index], _ = strconv.Atoi(element)
	}
	return intsli
}

func MakeFourPartitions(sli []int) (p1, p2, p3, p4 []int) {
	partitionSize := len(sli) / 4
	partition1 := sli[:partitionSize]
	partition2 := sli[partitionSize : partitionSize*2]
	partition3 := sli[partitionSize*2 : partitionSize*3]
	partition4 := sli[partitionSize*3:]
	return partition1, partition2, partition3, partition4
}

func AddFourThreadsToWaitGroup(p1 []int, p2 []int, p3 []int, p4 []int, c chan []int) {
	var waitGroup sync.WaitGroup
	waitGroup.Add(4)

	SortAndAddToChannel(p1, c)
	waitGroup.Done()
	SortAndAddToChannel(p2, c)
	waitGroup.Done()
	SortAndAddToChannel(p3, c)
	waitGroup.Done()
	SortAndAddToChannel(p4, c)
	waitGroup.Done()

	waitGroup.Wait()
	close(c)
}

func main() {
	intsli := UserInputToSlice()
	p1, p2, p3, p4 := MakeFourPartitions(intsli)

	c := make(chan []int, 5)
	AddFourThreadsToWaitGroup(p1, p2, p3, p4, c)

	collectSortedPartitions := make([]int, 0)
	for elem := range c {
		collectSortedPartitions = append(collectSortedPartitions, elem...)
	}
	sort.Sort(sort.IntSlice(collectSortedPartitions))
	fmt.Println(collectSortedPartitions)
}
