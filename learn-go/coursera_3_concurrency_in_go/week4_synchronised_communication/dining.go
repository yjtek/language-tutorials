package main

import (
	"fmt"
	"strconv"
	"sync"
	"time"
)

/*
Implement the dining philosopher’s problem with the following constraints/modifications.

There should be 5 philosophers sharing chopsticks, with one chopstick between each adjacent pair of philosophers.

Each philosopher should eat only 3 times (not in an infinite loop as we did in lecture)

The philosophers pick up the chopsticks in any order, not lowest-numbered first (which we did in lecture).

In order to eat, a philosopher must get permission from a host which executes in its own goroutine.

The host allows no more than 2 philosophers to eat concurrently.

Each philosopher is numbered, 1 through 5.

When a philosopher starts eating (after it has obtained necessary locks) it prints “starting to eat <number>” on a line by itself, where <number> is the number of the philosopher.

When a philosopher finishes eating (before it has released its locks) it prints “finishing eating <number>” on a line by itself, where <number> is the number of the philosopher.
*/

type Philo struct {
	lcs *ChopS
	rcs *ChopS
	id  int
}

type ChopS struct {
	sync.Mutex
}

var wg sync.WaitGroup

func (p *Philo) eat(host chan int) {
	defer wg.Done()
	for i := 0; i < 3; i++ {
		if p.GetHostPermission(host) {
			p.lcs.Lock()
			p.rcs.Lock()

			fmt.Println("starting to eat " + strconv.Itoa(p.id))
			time.Sleep(time.Second)

			fmt.Println("finishing eating " + strconv.Itoa(p.id))
			time.Sleep(time.Second)
			p.lcs.Unlock()
			p.rcs.Unlock()
			<-host // Pop 1 value from channel after eat occurs
		}
	}
}

func (p *Philo) GetHostPermission(host chan int) bool {
	host <- 1 //send value to channel
	return true
}

func main() {
	host := make(chan int, 2)

	// make chopsticks
	csSlice := make([]*ChopS, 5)
	for j := 0; j < 5; j++ {
		csSlice[j] = new(ChopS)
	}

	// make philosophers
	philoSlice := make([]*Philo, 5)
	for k := 0; k < 5; k++ {
		philoSlice[k] = &Philo{lcs: csSlice[k], rcs: csSlice[(k+1)%5], id: k}
		wg.Add(1)
		go philoSlice[k].eat(host)
	}
	wg.Wait()
}
