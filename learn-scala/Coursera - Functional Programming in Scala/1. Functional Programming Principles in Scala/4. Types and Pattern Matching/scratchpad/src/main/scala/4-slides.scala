package mod4_slides4

enum Direction(val dx: Int, val dy: Int):
  case Right extends Direction( 1, 0)
  case Up extends Direction(0, 1)
  case Left extends Direction(-1, 0)
  case Down extends Direction( 0, -1)
  
  def leftTurn = Direction.values((ordinal + 1) % 4)
end Direction

val r = Direction.Right
val u = r.leftTurn // u = Up
val v = (u.dx, u.dy) // v = (1, 0)

enum Expr:
  case Var(s: String)
  case Number(n: Int)
  case Sum(e1: Expr, e2: Expr)
  case Prod(e1: Expr, e2: Expr)

@main def main() = {
  println(Direction.values.mkString(", "))
  Direction.values.foreach { color =>
    println(s"${color.toString}: ${color.ordinal}")
  }
  // println(Expr.values(1)) // Error, parameterised `case` does not have .values array
}