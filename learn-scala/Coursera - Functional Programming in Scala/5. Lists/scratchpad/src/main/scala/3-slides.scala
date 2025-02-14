package mod5_slides3

extension [T](l: List[T])
  def _filter(f: T => Boolean): List[T] = {
    l match
      case Nil => Nil
      case head :: tail => if f(head) then head :: tail._filter(f) else tail._filter(f)
  }
  
  def _filterNot(f: T => Boolean): List[T] = {
    l match
      case Nil => Nil
      case head :: tail => if !f(head) then head :: tail._filterNot(f) else tail._filterNot(f)
  }

  def _partition(f: T => Boolean): (List[T], List[T]) = {
    (l._filter(f), l._filterNot(f))
  }

  def _takeWhile(f: T => Boolean): List[T] = {
    def recur(subL: List[T], acc: List[T]): List[T] = {
      subL match
        case Nil => Nil
        case head :: tail => if f(head) then recur(tail, acc :+ head) else acc
    }
    recur(l, List())
  }

  def _dropWhile(f: T => Boolean): List[T] = {
    def recur(subL: List[T]): List[T] = {
      subL match
        case Nil => Nil
        case head :: tail => if f(head) then recur(tail) else head :: tail
    }
    recur(l)
  }

  def _span(f: T => Boolean): (List[T], List[T]) = {
    (l._takeWhile(f), l._dropWhile(f))
  }

def pack[T](l: List[T]): List[List[T]] = {
  def recur(subL: List[T], acc: List[List[T]]): List[List[T]] = {
    subL match
      case Nil => Nil
      case head :: tail => 
        val (matchingList, remainder) = subL._span(x => x == head)
        if !remainder.isEmpty then recur(remainder, acc :+ (head :: matchingList)) else acc :+ (head :: matchingList)
  }
  recur(l, List())
}

def runLengthEncode[T](l: List[T]): List[(T, Int)] = {
  val lpack = pack(l)
  def recur(subL: List[List[T]], acc: List[(T, Int)]): List[(T, Int)] = {
    subL match
      case Nil => acc
      case head :: tail => 
        recur(tail, acc :+ (head(0), head.size))
  }

  recur(lpack, List())
}

@main def main() = {
  val l = List(1,2,3,4,5,6,7)
  // println(l._takeWhile(x => x < 4))
  // println(l._dropWhile(x => x < 4))
  // println(l :+ 1)
  println(pack(List(1,1,1,2,2,3,4,5,5,5,1)))
  println(runLengthEncode(List(1,1,1,2,2,3,4,5,5,5,1)))
}