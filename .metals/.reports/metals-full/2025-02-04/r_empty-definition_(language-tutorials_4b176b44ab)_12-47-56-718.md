error id: mod3_slides5/
file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/3.%20Data%20and%20Abstraction/scratchpad/src/main/scala/5-slides.scala
empty definition using pc, found symbol in pc: mod3_slides5/
semanticdb not found
|empty definition using fallback
non-local guesses:
	 -

Document text:

```scala
package mod3_slides5

abstract class IntSet:
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(s: IntSet): IntSet

//The same Empty set can be reused every time, so can create it as an object instead of a class
object Empty extends IntSet:
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = NonEmpty(x, Empty, Empty)
  def union(s: IntSet): IntSet = s

// Recall that IntSet was defined in the form of a binary tree
object NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet:
  def contains(x: Int): Boolean = 

object IntSet:
  def apply(): IntSet = Empty
```

#### Short summary: 

empty definition using pc, found symbol in pc: mod3_slides5/