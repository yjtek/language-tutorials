error id: `<none>`.
file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/2.%20Functional%20Program%20Design%20in%20Scala/1.%20for%20Expressions%20and%20Monads/scratchpad/src/main/scala/4-slides.scala
empty definition using pc, found symbol in pc: `<none>`.
semanticdb not found
found definition using fallback; symbol Generator
Document text:

```scala
package mod1_slides4

trait Generator[+T]:
  def generate(): T

  def map[S](f: T => S) = new Generator[S]:
    def generate(): S = {
      f(Generator.this.generate())
    }

  def flatMap[S](f: T => Generator[S]) = new Generator[S]:
    f(Generator.this.generate()).generate()

// Integer generator
val integerGenerator = new Generator[Int]: 
  val rand = new java.util.Random()
  
  def generate(): Int = {
    rand.nextInt()
  }

// Same as above, except we use an explicit class instead of an anonymous class
class integerGeneratorFactory extends Generator[Int]:
  val rand = new java.util.Random()
  def generate(): Int = {
    rand.nextInt()
  }
val integerGenerator2 = integerGeneratorFactory()

val booleanGenerator = new Generator[Boolean]:
  def generate(): Boolean = {
    integerGenerator.generate() > 0
  }
// Same as above, without the boilerplate
val booleanGenerator2 = integerGenerator.map(x => x > 0)

val pairsGenerator = new Generator[(Int, Int)]:
  def generate(): (Int, Int) = {
    (integerGenerator.generate(), integerGenerator.generate())
  }
// Same as above, without the boilerplate
val pairsGenerator2 = integerGenerator.flatMap(x => integerGenerator.map(y => (x,y)))

@main def main() = {
  println(integerGenerator.generate())
  println(integerGenerator2.generate())

  println(booleanGenerator2.generate())
}
```

#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.