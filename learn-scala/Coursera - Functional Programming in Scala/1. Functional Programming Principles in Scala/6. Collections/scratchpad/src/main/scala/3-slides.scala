package mod6_slides3

//N-Queens
def myQueens(n: Int): Set[List[Int]] = {
  def recurse(queensRemaining: Int): Set[List[Int]] = {
    if queensRemaining == 0 then {
      Set(List())
    }
    else {
      for 
        candidateSet <- recurse(queensRemaining-1)
        candidateCol <- 0 until n
        if canPlaceColInSet(candidateCol, candidateSet, 1)
      yield candidateCol :: candidateSet
    }
  }
  recurse(n)
}

def canPlaceColInSet(candidateCol: Int, candidateSet: List[Int], delta: Int): Boolean = {
  candidateSet match
    case Nil => true
    case prevCol :: remainder => {
      if (
        (candidateCol == prevCol) ||
        ((candidateCol - prevCol).abs == delta) ||
        (!canPlaceColInSet(candidateCol, remainder, delta+1))
      ) then {
        false
      }
      else true
    } 
}

def queens(n: Int): Set[List[Int]] = {
  def placeQueens(k: Int): Set[List[Int]] =
    println(s"placeQueens(k: ${ k})")
    if k == 0 then Set(List())
    else
      for {
        queens <- placeQueens(k - 1)
        col <- 0 until n
        if isSafe(col, queens)
      }
      yield {
        println(s"queens: {$queens}")
        val newQueens = col :: queens
        println(s"newQeens: {$newQueens}")
        newQueens
      }
  placeQueens(n)
}

def isSafe(col: Int, queens: List[Int]): Boolean =
  println(s"isSafe(col: ${col}, queens: ${queens})")
  !checksFail(col, 1, queens)


def checksFail(col: Int, delta: Int, queens: List[Int]): Boolean = {
  println(s"checks(col: ${col}, delta: ${delta}, queens: ${queens})")
  queens match
    case qcol :: others =>
      qcol == col // vertical check
      || (qcol - col).abs == delta // diagonal check
      || checksFail(col, delta + 1, others)
    case Nil => false
}
@main def main() = {
  // println(queens(4))
  println(myQueens(4)) //my implementation
}