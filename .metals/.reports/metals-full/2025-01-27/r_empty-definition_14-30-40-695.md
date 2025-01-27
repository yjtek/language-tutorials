error id: length.
file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/1.%20Getting%20Started/2-functions-and-evaluation/assignments/recfun/src/main/scala/recfun/RecFun.scala
empty definition using pc, found symbol in pc: length.
empty definition using semanticdb
|empty definition using fallback
non-local guesses:
	 -prevRow/length.
	 -prevRow/length#
	 -prevRow/length().
	 -scala/Predef.prevRow.length.
	 -scala/Predef.prevRow.length#
	 -scala/Predef.prevRow.length().

Document text:

```scala
package recfun

import scala.collection.mutable.ArrayBuffer

object RecFun extends RecFunInterface:

  def main(args: Array[String]): Unit =
    println("Pascal's Triangle")
    for row <- 0 to 10 do
      for col <- 0 to row do
        print(s"${pascal(col, row)} ")
      println()

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    def _generate_pascal_row(r: Int): Array[Int] = {
      val arr = ArrayBuffer[Int]()
      if (r == 0) then Array[Int](1)
      else if (r == 1) then Array[Int](1, 1)
      else {
        ans = ArrayBuffer[Int](1)
        prevRow = _generate_pascal_row(r-1)
        for (i <- 0 to (prevRow.length - 1)) {
          ans += prevRow(i) + prevRow(i+1)
        }
        ans += 1
        ans.toArray
      }
        
    }
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = ???

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = ???

```

#### Short summary: 

empty definition using pc, found symbol in pc: length.