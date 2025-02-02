package slide7

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
    ((this.numerator/this.denominator) * that.denominator) < ((that.numerator/that.denominator) * this.denominator)
  }
  
  def max(that: Rational): Rational = {
    if this.less(that) then that else this
  }
end Rational

extension (r: Rational)
  def min(s: Rational): Rational = if s.less(r) then s else r
  def abs: Rational = Rational(r.numerator.abs, r.denominator)

@main def main() = {
  var temp = Rational(20, 16)
  println(temp.abs)
  println(temp.min(Rational(20,18)).toString())
}
