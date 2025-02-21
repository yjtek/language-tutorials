error id: java/
file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/2.%20Functional%20Program%20Design%20in%20Scala/1.%20for%20Expressions%20and%20Monads/scratchpad/src/main/scala/4-slides.scala
empty definition using pc, found symbol in pc: java/
semanticdb not found
|empty definition using fallback
non-local guesses:
	 -

Document text:

```scala
package mod1_slides4

trait Generator[+T]:
  def generate(): T

// Integer generator
val integerGenerator = new Generator[Int]: 
  val rand = java.util.Random()
  
  def generate(): Int = {
    rand.nextInt()
  }

class integerGeneratorFactory extends Generator:
  val rand = java.util.Random()
  def generate(): Int = {
    rand.nextInt()
  }

val booleanGenerator = new Generator[Boolean]:
  def generate(): Boolean = {
    integerGenerator.generate() > 0
  }

val pairsGenerator = new Generator[(Int, Int)]:
  def generate(): (Int, Int) = {
    (integerGenerator.generate(), integerGenerator.generate())
  }
```

#### Short summary: 

empty definition using pc, found symbol in pc: java/