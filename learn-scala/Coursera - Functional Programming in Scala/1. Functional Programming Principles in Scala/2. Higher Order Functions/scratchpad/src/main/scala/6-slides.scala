package slide6

class Rational(x: Int, y: Int):
  private def gcd(x: Int, y: Int): Int = {
    if y == 0 then x
    else gcd(y, x % y)
  }
  private var gcdVal: Int = gcd(x, y)

  def this(x: Int) = this(x, 1)

  // def numerator: Int = x /gcdVal
  // def denominator: Int = y / gcdVal
  // val numerator: Int = x / gcdVal
  // val denominator: Int = y / gcdVal
  val numerator: Int = x
  val denominator: Int = y

  override def toString() = {
    s"${numerator/gcdVal}/${denominator/gcdVal}"
  }

  def less(that: Rational): Boolean = {
    this.numerator * that.denominator < that.numerator * this.denominator
  }
  
  def max(that: Rational): Rational = {
    if this.less(that) then that else this
  }
end Rational

@main def main() = {
  var temp = Rational(20, 16)
  println(temp.toString())
  println(temp.numerator)
  println(temp.denominator)
  println(temp.less(Rational(20,18)))
}
