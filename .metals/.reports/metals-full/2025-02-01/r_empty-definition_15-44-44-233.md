error id: 
file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/1.%20Getting%20Started/2-functions-and-evaluation/scratchpad/src/main/scala/Main.scala
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
|empty definition using fallback
non-local guesses:
	 -

Document text:

```scala
import scala.math.abs

//============== MINE

// val tolerance = 0.0001

// def isCloseEnough(guess: Double, nextGuess: Double) = {
//   abs((nextGuess-guess)/guess) < tolerance
// }

// def getNextGuess(guess: Double): Double = {
//   nextGuess = guess/nextGuess
// }

// def fixedPoint(getNextGuess: Double => Double, isCloseEnough: (Double, Double) => Boolean)(guess: Double): Double = {
//   def recurs(guess: Double): Double = {
//     val nextGuess = getNextGuess(guess)
//     if isCloseEnough(guess, nextGuess) then nextGuess
//     else recurs(nextGuess)
//   }
//   recurs(guess)  
// }

// @main def sqrt(x: Double) = {
//   fixedPoint(y => x / y, isCloseEnough)(1.0)
// }

//============== MINE


```

#### Short summary: 

empty definition using pc, found symbol in pc: 