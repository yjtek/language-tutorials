error id: mod4_slides6/
file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/4.%20Types%20and%20Pattern%20Matching/scratchpad/src/main/scala/6-slides.scala
empty definition using pc, found symbol in pc: mod4_slides6/
semanticdb not found
|empty definition using fallback
non-local guesses:
	 -

Document text:

```scala
package mod4_slides6

// ==========================================
// Type variance

class IntSet
class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet
class Empty extends IntSet

@main def main() = {
  val a: Array[NonEmpty] = Array(NonEmpty(1, Empty(), Empty()))
  val b: Array[IntSet] = a
  b(0) = Empty()
  val s: NonEmpty = a(0)
}

// ==========================================
// Now, we define LIST to be covariant
trait LIST[+T]:
  def isEmpty = this match
    case Nil => true
    case _ => false
  
  override def toString =
    def recur(prefix: String, xs: LIST[T]): String = xs match
      case x :: xs1 => s"$prefix$x${recur(", ", xs1)}"
      case Nil => ")"
    recur("LIST(", this)

  def prepend(elem: T): List[T] = ::(elem, this)

// Same definition of function `::` to append to a list  
case class ::[+T](head: T, tail: LIST[T]) extends LIST[T]
// extension [T](x: T) def ::(xs: LIST[T]): LIST[T] = ::(x, xs)

// In the case of `Nil`, we extend from LIST[Nothing]. Recall that `Nothing` is a subclass of all other classes. So you can always append `LIST[Nothing]` into a list of any type `T` without breaking
case object Nil extends LIST[Nothing]

object LIST:
  def apply() = Nil
  def apply[T](x: T) = ::(x, Nil) //x :: Nil
  def apply[T](x1: T, x2: T) = x1 :: (x2 :: Nil)

  

```

#### Short summary: 

empty definition using pc, found symbol in pc: mod4_slides6/