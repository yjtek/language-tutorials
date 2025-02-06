package mod4_slides2

/*
  You can implement trait as a standalone 
*/
// trait Expr

/* 
  Alternatively, you can implement `eval` as a method of the base trait. The difference is the instead of using eval(...), you need to so Expr.eval
*/
trait Expr:
  def eval(): Int = this match
    case Number(n) => n
    case Sum(e1, e2) => e1.eval() + e2.eval()

case class Number(n: Int) extends Expr
case class Var(x: String) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr
case class Product(e1: Expr, e2: Expr) extends Expr 

def eval(e: Expr): Int = e match
  case Number(n) => n
  case Sum(e1, e2) => eval(e1) + eval(e2)

def show(e: Expr): String = e match
  case Number(n) => n.toString
  case Sum(e1, e2) => show(e1) + " + " + show(e2)

def showWithNewEntitiesP(e: Expr): String = e match
    case e: Sum => s"(${showWithNewEntities(e)})"
    case _ => showWithNewEntities(e)

def showWithNewEntities(e: Expr): String = e match
  case Number(n: Int) => n.toString
  case Var(x: String) => x.toString
  case Sum(e1: Expr, e2: Expr) => showWithNewEntities(e1) + " + " + showWithNewEntities(e2)
  case Product(e1: Expr, e2: Expr) => showWithNewEntitiesP(e1) + " * " + showWithNewEntitiesP(e2)

@main def main() = {
  /* standalone `eval` */
  // println(Number(5))
  // println(eval(Sum(Number(5), Number(50))))
  // println(show(Sum(Number(5), Number(50))))
  println(showWithNewEntities(Sum(Number(5), Number(50))))
  println(showWithNewEntities(Product(Sum(Number(2), Var("x")), Var("y"))))
  println(showWithNewEntities(Sum(Product(Number(2), Var("x")), Var("y"))))

  /* Non-standalone `eval` */
  // println(Sum(Number(5), Number(50)).eval())

}