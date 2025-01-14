package main

import (
	"encoding/json"
	"fmt"
)

type TestStruct struct {
	ID        int
	Name      string
	Colors    []string
	some_func func(int, int) int
}

type TestStruct2 struct {
	float_input []float32
}

func main() {

	// jsonData := `{"name": {"last": "Bob"}, "age": 18}`
	// // fmt.Println(jsonData)
	// value := gjson.Get(jsonData, "name.last")
	// println(value.String())

	YJ := TestStruct{
		ID:   90,
		Name: "YJ",
		// Colors: []string{"red", "green", "blue"},
		some_func: func(t1 int, t2 int) int {
			return t1 * t2
		},
	}
	// fmt.Println(YJ.some_func(10, 5))

	temp_var := []int{1, 1, 1}
	fmt.Println(temp_var)

	//transformed_input_request := make([]float32, 0, 8)
	transformed_input_request := []int32{1, 1, 1, 1, 1, 1, 1, 1}
	fmt.Println(transformed_input_request)

	b, err := json.Marshal(YJ)
	if err != nil {
		panic(err)
		// fmt.Println("error:", err)
	}
	//fmt.Println("json.Marshal Output")
	//os.Stdout.Write(b)

	// c, err := json.MarshalIndent(YJ, "<prefix>", "<indent>")
	// if err != nil {
	// 	panic(err)
	// 	// fmt.Println("error:", err)
	// }
	// fmt.Println(b)
	//fmt.Println("json.MarshalIndent Output")
	//os.Stdout.Write(c)

	unmarshaled_data := &TestStruct{}
	unmarshaled_err := json.Unmarshal(b, &unmarshaled_data)
	if unmarshaled_err != nil {
		panic(unmarshaled_err)
	}
	//fmt.Println(unmarshaled_data)
}

// import (
// 	"encoding/json"
// 	"fmt"
// 	"os"
// )

// func main() {
// 	type ColorGroup struct {
// 		ID     int
// 		Name   string
// 		Colors []string
// 	}
// 	group := ColorGroup{
// 		ID:     1,
// 		Name:   "Reds",
// 		Colors: []string{"Crimson", "Red", "Ruby", "Maroon"},
// 	}
// 	b, err := json.Marshal(group)
// 	if err != nil {
// 		fmt.Println("error:", err)
// 	}
// 	os.Stdout.Write(b)
// }
