package slides5

class Rational(x: Int, y: Int):
  def numerator = x
  def denominator = y

  def add(r: Rational): Rational = {
    Rational(
      (numerator * r.denominator) + (r.numerator * denominator),
      denominator * r.denominator
    )
  }

  def multiply(r: Rational): Rational = {
    Rational(
      numerator * r.numerator,
      denominator * r.denominator
    )
  }

  def neg(): Rational = {
    Rational(-numerator, denominator)
  }

  def sub(r: Rational): Rational = {
    Rational(
      (numerator * r.denominator) - (denominator * r.numerator),
      denominator * r.denominator
    )
  }

  override def toString = s"${numerator}/${denominator}"

val x = Rational(1,3)
val y = Rational(5,7)
val z = Rational(3,2)

@main def main() = {
  println(x.add(y).multiply(z))
  println(x.sub(y).sub(z))
}