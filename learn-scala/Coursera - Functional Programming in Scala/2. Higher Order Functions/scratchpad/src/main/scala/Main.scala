import scala.math.abs

val tolerance = 0.0001

def isCloseEnough(guess: Double, nextGuess: Double): Boolean = {
  abs((nextGuess - guess) / guess) < tolerance
}

def getNextGuess(candidate: Double)(guess: Double): Double = {
  candidate/guess
}

def getNextGuessDamping(candidate: Double)(guess: Double): Double = {
  (guess + candidate/guess) / 2
}

def fixedPoint(getNextGuessFunc: Double => Double, isCloseEnough: (Double, Double) => Boolean)(firstGuess: Double): Double = {
  def iterate(guess: Double): Double =
    val nextGuess = getNextGuessFunc(guess)
    println(guess + "||" + firstGuess + "||" + nextGuess)
    if isCloseEnough(guess, nextGuess) then nextGuess
    else iterate(nextGuess)
  iterate(firstGuess)
}

@main def sqrt(x: Double) = {
  // val res = fixedPoint(getNextGuess(x), isCloseEnough)(1.0)
  val res = fixedPoint(getNextGuessDamping(x), isCloseEnough)(1.0)
  println(res)
}