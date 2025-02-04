package slides1

abstract class IntSet:
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
end IntSet

class Empty() extends IntSet:
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = NonEmpty(x, Empty(), Empty())
  def union(s: IntSet): IntSet = s

class NonEmpty(val elem: Int, val left: IntSet, val right: IntSet) extends IntSet:
  def contains(x: Int): Boolean = {
    if x < elem then this.left.contains(x)
    else if x > elem then this.right.contains(x)
    else true
  }

  def incl(x: Int): IntSet = {
    if x < elem then NonEmpty(elem, left.incl(x), right)
    else if x > elem then NonEmpty(elem, left, right.incl(x))
    else this
  }

  def union(s: IntSet): IntSet = {
    /*
      In base case when left and right are `Empty`, this.left.union(this.right) returns an `Empty` object

      Empty.union(s) simply gives us `s`, which is presumably NonEmpty

      NonEmpty.incl(elem) will simply place `elem` as a node in the binary tree, and returns the root of the tree
    */
    
    this.left
    .union(this.right)
    .union(s)
    .incl(elem)
  }
