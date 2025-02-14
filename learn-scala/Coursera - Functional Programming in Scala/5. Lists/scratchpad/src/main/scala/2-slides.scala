package mod5_slides2

def mergeSort[T](l : List[T])(lt: (T,T) => Boolean): List[T] = {
  def merge(l1: List[T], l2: List[T]): List[T] = {
    (l1, l2) match 
      case (Nil, Nil) => Nil
      case (l1, Nil) => l1
      case (Nil, l2) => l2
      case (l1head :: l1tail, l2head :: l2tail) => {
        if (lt(l1head, l2head)) then {
          l1head :: merge(l1tail, l2)
        } else {
          l2head :: merge(l1, l2tail)
        }
      }
  }
  
  l match
    case Nil => Nil
    case elem :: Nil => List(elem)
    case _ => {
      val n = l.length / 2 //integer division by default
      val (firstHalf, secondHalf) = l.splitAt(n)
      merge(mergeSort(firstHalf)(lt), mergeSort(secondHalf)(lt))
    }
}

@main def main() = {
  println(List(1,2,3,4,5).splitAt(2))
  println(2/2)
  println(mergeSort(List(4,6,8,1,3,5))(_ < _))
}