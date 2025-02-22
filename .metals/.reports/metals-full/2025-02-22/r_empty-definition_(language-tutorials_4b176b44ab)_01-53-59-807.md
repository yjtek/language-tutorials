error id: mod1_slides6/
file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/2.%20Functional%20Program%20Design%20in%20Scala/1.%20for%20Expressions%20and%20Monads/scratchpad/src/main/scala/6-slides.scala
empty definition using pc, found symbol in pc: mod1_slides6/
semanticdb not found
|empty definition using fallback
non-local guesses:
	 -

Document text:

```scala
package mod1_slides6

import scala.util.Try

def regularTryCatch() = {
  try {
    println(1/0)
  } 
  catch {
    case ex: Exception => println("WTF"); throw ex
  }
}

abstract class Try[+T]
case class Success[+T](x: T) extends Try[T]
case class Failure(ex: Exception) extends Try[Nothing]

object Try:
  def apply[T](expr: => T): Try[T] =
    try Success(expr)
    catch case NonFatal(ex) => Failure(ex)

def gracefulTry() = {
  
}

@main def main() = {
  println(regularTryCatch())
}
```

#### Short summary: 

empty definition using pc, found symbol in pc: mod1_slides6/