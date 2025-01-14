package main

import (
	"fmt"

	"gonum.org/v1/gonum/mat"
)

func main() {
	somevar := []float64{3.0, 4.0, 2.0, 1.0}
	modelProbs := mat.NewDense(1, 4, somevar)
	_, cols := modelProbs.Dims()
	slice := []float64{}
	for j := 0; j < cols; j++ {
		slice = append(slice, modelProbs.At(0, j))
	}
	fmt.Println(slice)

	return
}
