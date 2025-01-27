error id: zipWithIndex.
file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/1.%20Getting%20Started/2-functions-and-evaluation/assignments/recfun/src/main/scala/recfun/RecFun.scala
empty definition using pc, found symbol in pc: zipWithIndex.
empty definition using semanticdb
|empty definition using fallback
non-local guesses:
	 -zipWithIndex.
	 -zipWithIndex#
	 -zipWithIndex().
	 -scala/Predef.zipWithIndex.
	 -scala/Predef.zipWithIndex#
	 -scala/Predef.zipWithIndex().

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
      if r == 0 then ArrayBuffer[Int](1)
      else if r == 1 then ArrayBuffer[Int](1, 1)
      else if r == 2 then ArrayBuffer[Int](1, 2, 1)
      else {
        prev_row = _generate_pascal_row(r-1)
        
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

empty definition using pc, found symbol in pc: zipWithIndex.