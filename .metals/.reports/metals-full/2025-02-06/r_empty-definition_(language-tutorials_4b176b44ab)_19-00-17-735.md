error id: file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/4.%20Types%20and%20Pattern%20Matching/scratchpad/src/main/scala/5-slides.scala:15
file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/4.%20Types%20and%20Pattern%20Matching/scratchpad/src/main/scala/5-slides.scala
empty definition using pc, found symbol in pc: 
semanticdb not found
|empty definition using fallback
non-local guesses:
	 -Empty.
	 -Empty#
	 -Empty().
	 -scala/Predef.Empty.
	 -scala/Predef.Empty#
	 -scala/Predef.Empty().

Document text:

```scala
package mod4_slides5

abstract class IntSet:
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(s: IntSet): IntSet

object Empty extends IntSet
class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet

// IntSet
//   - Empty
//   - NonEmpty


val a: Array[NonEmpty] = Array(NonEmpty(1, Empty, Empty))
val b: Array[IntSet] = a
b(0) = Empty()
val s: NonEmpty = a(0)
```

#### Short summary: 

empty definition using pc, found symbol in pc: 