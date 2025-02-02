error id: slide6/
file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/2.%20Higher%20Order%20Functions/scratchpad/src/main/scala/6-slides.scala
empty definition using pc, found symbol in pc: slide6/
semanticdb not found
|empty definition using fallback
non-local guesses:
	 -

Document text:

```scala
package slide6

class Rational(x: Int, y: Int):
  private def gcd(x: Int, y: Int): Int = {
    if y == 0 then x
    else gcd(y, x % y)
  }

  private var gcdVal: Int = gcd(x, y)

  def numerator: Int = x /gcdVal
  def denominator: Int = y / gcdVal

  override def toString() = {
    s"${numerator}/${denominator}"
  }

@main def main() = {
  var temp = Rational(20, 16)
  println(temp.toString())
}

```

#### Short summary: 

empty definition using pc, found symbol in pc: slide6/