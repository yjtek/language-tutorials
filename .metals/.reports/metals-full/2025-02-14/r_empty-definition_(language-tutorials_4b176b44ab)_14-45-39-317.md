error id: mod6_slides1/
file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/6.%20Collections/scratchpad/src/main/scala/1-slides.scala
empty definition using pc, found symbol in pc: mod6_slides1/
semanticdb not found
|empty definition using fallback
non-local guesses:
	 -

Document text:

```scala
package mod6_slides1

//Experimenting with `Range`s
def range() = {
  println((1 to 5).foldLeft(0)(_ + _))
  println((1 to 5 by 2).foldLeft(0)(_ + _))
  println((1 until 5).foldLeft(0)(_ + _))
  print(List(1,2,3,4).sum)
}

//Map vs FlatMap
def mapVSflatMap() = {
  val l = List(1,2,3,4,5)
  println(l.map(x => List(x, x*2, List(x*3, x*4)))) //map function to list
  println(l.flatMap(x => List(x, x*2, List(x*3, x*4)))) //map function to list AND flatten by 1 level, does not flatten recursively
}

//Implement `combination()`
def combinations(v1: Vector[Int], v2: Vector[Int]): Vector[(Int, Int)] = {
  //v1.map(x => v2.map(y => (x,y))) //Vector[Vector[(Int, Int)]]
  v1.flatMap(x => v2.map(y => (x,y))) //Vector[(Int, Int)]
}

// def sumProduct(v1: Vector[Int], v2: Vector[Int]): Int = {
//   v1.zip(v2)
// }

@main def main() = {
  // mapVSflatMap()
  // println(combinations(Vector(1,2,3), Vector(4,5,6)))
  val v1 = Vector(1,2,3)
  val v2 = Vector(4,5,6)
  println(v1.zip(v2).map((x,y) => x*y).sum)
}


```

#### Short summary: 

empty definition using pc, found symbol in pc: mod6_slides1/