error id: mod5_slides4/
file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/5.%20Lists/scratchpad/src/main/scala/4-slides.scala
empty definition using pc, found symbol in pc: mod5_slides4/
semanticdb not found
|empty definition using fallback
non-local guesses:
	 -

Document text:

```scala
package mod5_slides4

// ==============================
// Compare foldLeft vs foldRight
def foldLeftVSRight() = {
  val l1 = List(1,2,3)
  val l2 = List(10,20,30)
  println(l1.foldLeft(l2)(_ :+ _)) // (((10,20,30) :+ 1) :+ 2) :+ 3
  println(l1.foldRight(l2)(_ :: _)) // (1 ::: (2 ::: (3 ::: List(10,20,30))))
}

// ==============================
// Implement foldLeft, reduceLeft, foldRight, reduceRight
extension [T](l: List[T])
  def _foldLeft[U](init: U)(f: (U,T) => U): U = {
    l match
      case Nil => init
      case head :: tail => tail._foldLeft(f(init, head))(f) 
  }

  def _foldRight[U](init: U)(f: (T,U) => U): U = {
    l match
      case Nil => init
      case head :: tail => f(head, tail._foldRight(init)(f))
  }

  def _reduceLeft(f: (T, T) => T): T = {
    l match
      case Nil => throw new Error("cannot reduce nil list")
      case head :: tail => tail._foldLeft(head)(f)
  }

  def _reduceRight(f: (T, T) => T): T = {
    l match
      case Nil => throw new Error("cannot reduce nil list")
      case head :: Nil => head
      case head :: tail => f(head, tail._reduceRight(f))
  }

// ==============================
// Impement `reverse` for a list in O(N)

def reverse[T](l: List[T]): List[T] = {
  l.
}
```

#### Short summary: 

empty definition using pc, found symbol in pc: mod5_slides4/