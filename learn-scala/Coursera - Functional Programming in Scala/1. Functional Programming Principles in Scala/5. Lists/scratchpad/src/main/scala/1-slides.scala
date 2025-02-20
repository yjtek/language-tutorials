package mod5_slides1

def last[T](l: List[T]): T = {
  /*
    This is O(N), because you iterate over the whole list to get the last element (because List in Scala is linked list)
  */
  l match
    case Nil => throw new Error("empty list has no last element")
    case List(x) => x
    case elem :: tail => last(tail)
}

def init[T](l: List[T]): List[T] = {
  /*
    This is O(N), because you traverse the list recursively until you hit the last element
  */
  l match
    case Nil => throw new Error("empty list has no init")
    case List(x) => List()
    case elem :: tail => elem :: init(tail)
}

def removeAt[T](n: Int, l: List[T]): List[T] = {
  def recurse(n: Int, l: List[T], acc: List[T]): List[T] = {
    if (n == 0) {
      acc ::: l.tail
    } else {
      recurse(n-1, l.tail, acc ::: List(l.head))
    }
  }
  recurse(n, l, List())
}

def flatten(l: List[Any]): List[Any] = {
  l match 
    case Nil => Nil
    case (h: List[Any]) :: (tail: Any) => flatten(h) ::: flatten(tail)
    case (h: Any) :: (tail: Any) => List(h) ::: flatten(tail)
}

extension [T](l: List[T])
  infix def `MY++` (l2: List[T]): List[T] = {
    /*
      O(M) where M is the length of `l2`
    */
    (l, l2) match
      case (Nil, Nil) => Nil
      case (l, Nil) => l
      case (Nil, l2) => l2
      case (l, l2) => {
        l2 match 
          case List(x) => l :+ x
          case elem :: tail => (l :+ elem) ++ tail
      }
  }

  def MYreverse: List[T] = {
    /*
      O(N^2), because Myreverse is constantly getting called on a (shrinking) list, so you reverse the same elements multiple times

      Suppose we have List(1,2,3). Then
        - List(1,2,3).MYreverse
          - List(2,3).MYreverse `MY++` List(1)
            - List(3).MYreverse `MY++` List(2)
              - List().MYreverse `MY++` List(3)
            - List(3)
          - List(3,2)
        - List(3,2,1)

    */
    l match 
      case Nil => Nil
      case elem :: tail => tail.MYreverse `MY++` List(elem)
  }

  def MYBetterReverse: List[T] = {
    /*
      Instead of calling l.Myreverse repeatedly, we can do tail recursion. Suppose we have List(1,2,3). Then
        - recursiveReverseSmallerList(List(1,2,3), List())
          - recursiveReverseSmallerList(List(2,3), 1 :: List())
            - recursiveReverseSmallerList(List(3), 2 :: List(1))
              - recursiveReverseSmallerList(List(), 3 :: List(2,1))
              - List(3,2,1)
      
      This saves time because, unlike Myreverse above, this doesn't require stack memory due to the additional ++ operation
    */
    def recursiveReverseSmallerList(l: List[T], acc: List[T]): List[T] = {
      l match 
        case Nil => acc
        case elem :: tail => recursiveReverseSmallerList(tail, elem :: acc)
    }
    recursiveReverseSmallerList(l, List())
  }

@main def main() = {
  val l = List(1,2,3,4,5,6,7)
  println(last(l))
  println(init(l))
  println(l `MY++` List(8,9,10))
  println(l.MYreverse)
  println(l.MYBetterReverse)
  println(removeAt(3, l))
  println(flatten(List(1,2,3, List(4,5,6), 7)))
  println(flatten(List(List(1, 1), 2, List(3, List(5, 8)))))
}