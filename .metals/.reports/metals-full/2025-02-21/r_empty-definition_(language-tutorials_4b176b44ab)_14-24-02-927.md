error id: file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/2.%20Functional%20Program%20Design%20in%20Scala/1.%20for%20Expressions%20and%20Monads/scratchpad/src/main/scala/4-slides.scala:105
file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/2.%20Functional%20Program%20Design%20in%20Scala/1.%20for%20Expressions%20and%20Monads/scratchpad/src/main/scala/4-slides.scala
empty definition using pc, found symbol in pc: 
semanticdb not found
|empty definition using fallback
non-local guesses:
	 -emptyList.
	 -emptyList#
	 -emptyList().
	 -scala/Predef.emptyList.
	 -scala/Predef.emptyList#
	 -scala/Predef.emptyList().

Document text:

```scala
package mod1_slides4

trait Generator[+T]:
  def generate(): T

  def map[S](f: T => S) = new Generator[S] {
    def generate(): S = {
      f(Generator.this.generate())
    }
  }

  def flatMap[S](f: T => Generator[S]) = new Generator[S]:
    def generate(): S = { 
      f(Generator.this.generate()).generate()
    }

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

//Equivalent representations of booleanGenerator
val booleans1 = for x <- integerGenerator yield x > 0
val booleans2 = integerGenerator.map(x => x > 0)
val booleans3 = new Generator[Boolean]:
  def generate() = ((x: Int) => x > 0)(integerGenerator.generate())
val booleans4 = new Generator[Boolean]:
  def generate() = integerGenerator.generate() > 0

//Equivalent representations of pairGenerator
def pairs1[T, U](t: Generator[T], u: Generator[U]): Generator[(T, U)] = {
  t.flatMap(
    x => u.map(
      y => (x, y)
    )
  )
}

def pairs2[T, U](t: Generator[T], u: Generator[U]): Generator[(T, U)] = {
  t.flatMap(
    x => new Generator[(T, U)] { 
      def generate() = (x, u.generate()) 
    }
  )
}

def pairs3[T, U](t: Generator[T], u: Generator[U]): Generator[(T, U)] = {
  new Generator[(T, U)]:
    def generate() = {
      (
        new Generator[(T, U)]: 
          def generate() = (t.generate(), u.generate())
      ).generate()
  }
}

def pairs4[T, U](t: Generator[T], u: Generator[U]): Generator[(T, U)] = {
  new Generator[(T, U)]:
    def generate() = (t.generate(), u.generate())
}

// Some other generators
def single[T](x: T): Generator[T] = new Generator[T]:
  def generate() = x
  
def range(lo: Int, hi: Int): Generator[Int] =
  for 
    x <- integerGenerator 
  yield 
    lo + x.abs % (hi - lo)

def oneOf[T](xs: T*): Generator[T] =
  for 
    idx <- range(0, xs.length) 
  yield 
    xs(idx)

def listGenerator: Generator[List[Int]] = {
  for 
    genEmptyList <- booleanGenerator
    list <- if genEmptyList then emptyList else nonEmptyList
  yield
    list
}

object emptyList = List()
object nonEmptyList = List()


@main def main() = {
  // println(integerGenerator.generate())
  // println(integerGenerator2.generate())

  // println(booleanGenerator2.generate())
  // println(pairsGenerator2.generate())

  // println(booleans1.generate())
  // println(booleans2.generate())
  // println(booleans3.generate())
  // println(booleans4.generate())

  // println(pairs1(integerGenerator, integerGenerator).generate())
  // println(pairs2(integerGenerator, integerGenerator).generate())
  // println(pairs3(integerGenerator, integerGenerator).generate())
  // println(pairs4(integerGenerator, integerGenerator).generate())

  // println(single(5).generate())
  // println(range(1, 10).generate())
  // println(oneOf(1,2,3,4,5).generate())
}
```

#### Short summary: 

empty definition using pc, found symbol in pc: 