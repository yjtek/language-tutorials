package mod4_slides5

import scala.collection.mutable.ArrayBuffer

// ==========================================
// Type bounds

class SuperClass {
  ???
}

class SubClass extends SuperClass {
  ???
}

class AnotherClass {
  ???
}

def func(param1: SubClass): Option[String] = {
  ???
}

@main def main() = {
  val test1 = SuperClass()
  val test2 = SubClass()
  val test3 = AnotherClass()

  func(test1)
  func(test2)
  func(test3)
}

// ==========================================
// Covariance

class IntSet {???}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet
class Empty() extends IntSet

val a: Array[NonEmpty] = Array(NonEmpty(1, Empty(), Empty()))
val b: Array[IntSet] = a
val s: NonEmpty = a(0)

@main def main() = {
  b(0) = Empty()
}