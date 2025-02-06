error id: file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/3.%20Data%20and%20Abstraction/scratchpad/src/main/scala/5-slides.scala:18
file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/3.%20Data%20and%20Abstraction/scratchpad/src/main/scala/5-slides.scala
empty definition using pc, found symbol in pc: 
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
  def contains(x: Int): Boolean = {
    if x < elem then left.contains(x)
    else if x > elem then right.contains(x)
    else true
  }

  def incl(x: Int): IntSet = {
    if x > elem then NonEmpty(elem, left, right.incl(x))
    else if x < elem then NonEmpty(elem, left.incl(x), right)
    else 
  }

object IntSet:
  def apply(): IntSet = Empty
```

#### Short summary: 

empty definition using pc, found symbol in pc: 