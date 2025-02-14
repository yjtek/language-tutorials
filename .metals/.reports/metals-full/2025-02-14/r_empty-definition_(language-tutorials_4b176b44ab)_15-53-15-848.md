error id: mod6_slides2/
file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/6.%20Collections/scratchpad/src/main/scala/2-slides.scala
empty definition using pc, found symbol in pc: mod6_slides2/
semanticdb not found
|empty definition using fallback
non-local guesses:
	 -

Document text:

```scala
package mod6_slides2

//Check prime filter
def getAllPairs(n: Int): Seq[(Int, Int)] = {
  (1 to n).flatMap(i => (
    (1 to i).map(j => (
      (i, j)   
    ))
  ))
}

def isPrime(x: Int): Boolean = {
  val upper = Math.floor(Math.sqrt(x)).toInt
  (2 to upper).forall(v => ((x % v)!= 0))
}

def getPrimeSums(s: Seq[(Int, Int)]): Seq[(Int, Int)] = {
  s.filter((x,y) => isPrime(x+y))
}

def getPrimeSums2(n: Int): Seq[(Int, Int)] = {
  for 
    i <- 1 to n
    j <- 1 to i
    if isPrime(i+j)
  yield (i,j)
}

//implement scalarProduct
def scalarProduct(l1: List[Int], l2: List[Int]): Int = {
  (for (x,y) <- l1.zip(l2) yield x*y).sum
}


@main def main() = {
  println(getPrimeSums(getAllPairs(10)))
  println(getPrimeSums2(10))

  println(scalarProduct(List(1,2,3), List(4,5,6)))
}
```

#### Short summary: 

empty definition using pc, found symbol in pc: mod6_slides2/