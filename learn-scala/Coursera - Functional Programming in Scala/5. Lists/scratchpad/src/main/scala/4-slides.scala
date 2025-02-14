package mod5_slides4

// ==============================
// Compare foldLeft vs foldRight
def foldLeftVSRight() = {
  val l1 = List(1,2,3)
  val l2 = List(10,20,30)
  println(l1.foldLeft(l2)(_ :+ _)) // (((10,20,30) :+ 1) :+ 2) :+ 3
  println(l1.foldRight(l2)(_ :: _)) // (1 ::: (2 ::: (3 ::: List(10,20,30))))
}

// ==============================
// Implement foldLeft, reduceLeft, foldRight, reduceRight
extension [T](l: List[T])
  def _foldLeft[U](init: U)(f: (U,T) => U): U = {
    l match
      case Nil => init
      case head :: tail => tail._foldLeft(f(init, head))(f) 
  }

  def _foldRight[U](init: U)(f: (T,U) => U): U = {
    l match
      case Nil => init
      case head :: tail => f(head, tail._foldRight(init)(f))
  }

  def _reduceLeft(f: (T, T) => T): T = {
    l match
      case Nil => throw new Error("cannot reduce nil list")
      case head :: tail => tail._foldLeft(head)(f)
  }

  def _reduceRight(f: (T, T) => T): T = {
    l match
      case Nil => throw new Error("cannot reduce nil list")
      case head :: Nil => head
      case head :: tail => f(head, tail._reduceRight(f))
  }

// ==============================
// Impement `reverse` for a list in O(N)

def reverse[T](l: List[T]): List[T] = {
  // l.foldLeft(List())((acc, x) => x :: acc) //OR
  l.foldRight(List())((x, acc) => acc :+ x)
}

// ==============================
// Exercise

def mapFun[T, U](l: List[T], f: T => U): List[U] = {
  // l.foldRight(List[U]())((x, acc) => f(x) +: acc) //OR 
  l.foldLeft(List[U]())((acc, x) => acc :+ f(x)) //OR 
}

def lengthFun[T](l: List[T]): Int = {
  l.foldRight(0)((x, acc) => acc + 1) //OR
  // l.foldLeft(0)((acc, x) => acc + 1)
}

@main def main() = {
  val l = List(1,2,3,4,5)
  println(mapFun(l, x => x*2))
  println(lengthFun(l))
}