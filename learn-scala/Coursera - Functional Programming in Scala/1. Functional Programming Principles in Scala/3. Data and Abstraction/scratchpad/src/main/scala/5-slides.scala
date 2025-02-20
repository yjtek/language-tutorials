package mod3_slides5

abstract class IntSet:
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(s: IntSet): IntSet

//The same Empty set can be reused every time, so can create it as an object instead of a class
object Empty extends IntSet:
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = NonEmpty(x, Empty, Empty) //return new instance of NonEmpty
  def union(s: IntSet): IntSet = s

// Recall that IntSet was defined in the form of a binary tree, so you have elem, left, and right
class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet:
  def contains(x: Int): Boolean = {
    if x < elem then left.contains(x)
    else if x > elem then right.contains(x)
    else true
  }

  def incl(x: Int): IntSet = {
    if x > elem then NonEmpty(elem, left, right.incl(x))
    else if x < elem then NonEmpty(elem, left.incl(x), right)
    else this
  }

  // recursively build the tree
  def union(s: IntSet): IntSet = {
    this.left.union(this.right).union(s).incl(elem)
  }

// To enable multiple constructor signatures, we rely on polymorphism of the `apply` method. Recall that in Scala, `apply` is called to instantiate an object/class. So Object(42) is equivalent to Object.apply(42)
object IntSet:
  def apply(): IntSet = Empty
  def apply(x: Int): IntSet = Empty.incl(x)
  def apply(x: Int, y: Int): IntSet = Empty.incl(x).incl(y)