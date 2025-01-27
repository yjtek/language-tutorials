package recfun

import scala.collection.mutable.ArrayBuffer
import scala.util.boundary, boundary.break
import scala.collection.mutable
import scala.util.control.Breaks._

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
        val ans = ArrayBuffer[Int](1)
        val prevRow = _generate_pascal_row(r-1)
        for (i <- 0 to (prevRow.length - 2)) {
          ans += prevRow(i) + prevRow(i+1)
        }
        ans += 1
        ans.toArray
      }
    }
    _generate_pascal_row(r)(c)
  }

  /**
   * Exercise 2
   */
  def _balance(chars: List[Char]): Boolean = {
    val stack = mutable.Stack[Char]()
    var isBalanced = true

    chars.foreach {
        case '(' => stack.push('(')
        case ')' =>
        if (stack.isEmpty) {
            isBalanced = false
        } else {
            stack.pop()
        }
        case _ => // Ignore other characters
    }

    isBalanced && stack.isEmpty
    }

  def balance(chars: List[Char]): Boolean = {
    val stack = mutable.Stack[Char]()
    var isBalanced = true
    var i = 0
    
    while (i < chars.length && isBalanced) {
      if chars(i) == '(' then stack.push('(')
      else if chars(i) == ')' then {
        if stack.isEmpty then {
          isBalanced = false
        } else {
          stack.pop()
        }
      }
      i+=1
    }

    isBalanced && stack.isEmpty
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def solve(index: Int, remaining_money: Int): Int = {
      if remaining_money == 0 then 1
      else if ((remaining_money < 0) || (index >= coins.length)) then 0
      else {
        val count_include_index = solve(index, remaining_money - coins(index))
        val count_exclude_index = solve(index+1, remaining_money)
        count_include_index + count_exclude_index
      }
    }
    solve(0, money)
  }
