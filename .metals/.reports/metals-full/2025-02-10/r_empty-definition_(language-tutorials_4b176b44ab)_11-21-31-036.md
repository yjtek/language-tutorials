error id: file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/4.%20Types%20and%20Pattern%20Matching/scratchpad/src/main/scala/6-slides.scala:30
file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/4.%20Types%20and%20Pattern%20Matching/scratchpad/src/main/scala/6-slides.scala
empty definition using pc, found symbol in pc: 
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

// @main def main() = {
//   val a: Array[NonEmpty] = Array(NonEmpty(1, Empty(), Empty()))
//   val b: Array[IntSet] = a
//   b(0) = Empty()
//   val s: NonEmpty = a(0)
// }

// ==========================================
// Now, we define LIST to be covariant
trait LIST[+T]:
  def isEmpty = this match
    case NIL => true
    case _ => false
  
  override def toString =
    def recur(prefix: String, xs: LIST[T]): String = xs match
      case DecomposedLIST(x, xs1) => s"$prefix$x${recur(", ", xs1)}"
      case NIL => ")"
    recur("LIST(", this)

  // def prepend(elem: T): LIST[T] = elem :: this //will give error, because elem: T should be contravariant
  def prepend[U >: T](elem: U): LIST[U] = DecomposedLIST(elem,this) // or elem :: this

/* 
  Same definition of function `::` to append to a list. Note that you are unable to define the case class as `::` (though that's what it says in the notes). Why? Because in Scala, namespace for types and methods is shared (wtf?). So the compiler considers this a conflict if you have an extension called `::` and a type called `::`.

  Since the main purpose of the case class is to let Scala give you the boilerplate `unapply` functionality to decompose a list into `head` and `tail`, we can simply rename it to something more informative than `::`. 
*/
case class DecomposedLIST[+T](head: T, tail: LIST[T]) extends LIST[T]

extension [T](x: T) def ::(xs: LIST[T]): LIST[T] = DecomposedLIST(x, xs)

// In the case of `Nil`, we extend from LIST[Nothing]. Recall that `Nothing` is a subclass of all other classes. So you can always append `LIST[Nothing]` into a list of any type `T` without breaking
case object NIL extends LIST[Nothing]

object LIST:
  def apply() = Nil
  def apply[T](x: T) = x :: NIL
  def apply[T](x1: T, x2: T) = x1 :: x2 :: NIL

@main def main() = {
  val a = LIST(1, 2)
  val b = LIST(1, "wtf")
  println(a)
  println(b)
}
```

#### Short summary: 

empty definition using pc, found symbol in pc: 