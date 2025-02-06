error id: mod4_slides2/
file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/4.%20Types%20and%20Pattern%20Matching/scratchpad/src/main/scala/2-slides.scala
empty definition using pc, found symbol in pc: mod4_slides2/
semanticdb not found
|empty definition using fallback
non-local guesses:
	 -

Document text:

```scala
package mod4_slides2

trait Expr
case class Number(n: Int) extends Expr = {
  def toString = {
    "Number: " + n
  }
}
case class Sum(e1: Expr, e2: Expr) extends Expr

def eval(e: Expr): Int = e match
  case Number(n) => n
  case Sum(e1, e2) => eval(e1) + eval(e2)

@main def main() = {
  println(eval(Sum(Number(5), Number(50))))
}
```

#### Short summary: 

empty definition using pc, found symbol in pc: mod4_slides2/