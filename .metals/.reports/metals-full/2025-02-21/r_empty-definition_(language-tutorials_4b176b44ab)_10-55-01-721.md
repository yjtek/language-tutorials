error id: mod1_slides4/
file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/2.%20Functional%20Program%20Design%20in%20Scala/1.%20for%20Expressions%20and%20Monads/scratchpad/src/main/scala/4-slides.scala
empty definition using pc, found symbol in pc: mod1_slides4/
semanticdb not found
|empty definition using fallback
non-local guesses:
	 -

Document text:

```scala
package mod1_slides4

trait Generator[+T]:
  def generate(): T

val pairs = new Generator[(Int, Int)]: {
  def generate() = (integers.generate(), integers.generate())
}

```

#### Short summary: 

empty definition using pc, found symbol in pc: mod1_slides4/