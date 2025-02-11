package mod4_assignment

abstract class CodeTree
case class Fork(left: CodeTree, right: CodeTree, chars: List[Char], weight: Int) extends CodeTree
case class Leaf(char: Char, weight: Int) extends CodeTree

@main def main() = {
  val l = List(1,3,5,2,4,6)
  println(l.distinct.map(int => (int, l.count(x => x >= int))))
}
