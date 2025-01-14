# Encapsulation

- Go has a lot of support for encapsulation and keeping private data

- Remember, encapsulation is simply hiding data away so people don't use it directly, only through the methods you define

- Access control: Define public functions to allow access to hidden data

```
package data
var x int = 1
func PrintX() {fmt.Println(x)}  //Notice PrintX is capitalized. This means that it gets exported when the package is imported

+++

package main
import "data"
func main() {
    data.PrintX() //You can access var x ONLY through PrintX() function
}
```

- Besides access control to data, you can control access structs also
    - You can hide fields of structs by starting field names with lower-case letter
    - Then define public methods that enable access to hidden data

```
package data
type Point struct {
    x float64
    y float64
}

// Note that all the methods defined for the Point type are public, because of their capital letters

func (p *Point) InitMe(xn, yn float64){ //this function allows you to access x,y fields in `Point` type
    p.x = xn
    p.y = yn
}
func (p *Point) Scale(v float64){
    p.x = p.x*v
    p.y = p.y*v
}
func (p *Point) PrintMe(){
    fmt.Println(p.x, p.y)
}

+++

package main
import "data"
func main(){
    var p data.Point //You cannot access p.x or p.y, because not public
    p.InitMe(3,4) //But you can access them through the public methods you define
    p.Scale(2)
    p.Printme()
}

```

