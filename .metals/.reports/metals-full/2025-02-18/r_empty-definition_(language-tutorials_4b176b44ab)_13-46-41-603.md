error id: file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/6.%20Collections/scratchpad/src/main/scala/5-slides.scala:76
file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/6.%20Collections/scratchpad/src/main/scala/5-slides.scala
empty definition using pc, found symbol in pc: 
semanticdb not found
|empty definition using fallback
non-local guesses:
	 -

Document text:

```scala
package mod6_slides5

class Coder2(words: List[String]):
  val mnemonics = Map(
    '2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL",
    '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ"
  )

  val mapCharToNumber = mnemonics.foldLeft(Map[Char, Char]()){
    case (acc, (key,value)) => {
      acc ++ value.map(char => char -> key)
    }
  }

  def wordToNumber(word: String): String = {
    word.toUpperCase.foldLeft("") {
      case (acc, x) => {
        acc + mapCharToNumber(x)
      }
    }
  }
  
  val mapEncodingNumberToCandidateString: Map[String, List[String]] = {
    this.words.groupBy(wordToNumber).withDefaultValue(Nil)
  }

  /* 
    Keep in mind that a number can have multiple strings. Since numbers do not indicate white space, you could easily end up with multiple possible values. A stupid example would be like 12345. This could end up be "AB CDE", or "ABC DE". `encode()` needs to take this into account
  */
  def decodeAllPossibleString(number: String): Set[List[String]] = {
    if number.isEmpty then Set(Nil)
    else  
      for
        splitNumIndex <- (1 to number.length).toSet
        candidateWord <- this.mapEncodingNumberToCandidateString(number.take(splitNumIndex))
        remainder <- decodeAllPossibleString(number.drop(splitNumIndex))
      yield
        println(splitNumIndex) 
        println(candidateWord)
        println(remainder)
        candidateWord :: remainder
  }

class Coder(words: List[String]):
  val mnemonics = Map(
    '2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL",
    '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ"
  )
  
  /** Maps a letter to the digit it represents */
  private val charCode: Map[Char, Char] =
    for (digit, str) <- mnemonics; ltr <- str yield ltr -> digit
  
  /** Maps a word to the digit string it can represent */
  private def wordCode(word: String): String = word.toUpperCase.map(charCode)
  
  /** Maps a digit string to all words in the dictionary that represent it */
  private val wordsForNum: Map[String, List[String]] =
    words.groupBy(wordCode).withDefaultValue(Nil)

  def encode(number: String): Set[List[String]] =
    if number.isEmpty then Set(Nil)
    else
      for
        splitPoint <- (1 to number.length).toSet
        word <- wordsForNum(number.take(splitPoint))
        rest <- encode(number.drop(splitPoint))
      yield word :: rest

// @main def code(number: String) =
@main def code() =
  val coder = Coder2(List(
    "Scala", "Python", "Ruby", "C",
    "rocks", "socks", "sucks", "works", "pack"
  ))
  println(coder.mapEncodingNumberToCandidateString)
  // println(coder.decodeAllPossibleString(number).map(_.mkString(" ")))
  
```

#### Short summary: 

empty definition using pc, found symbol in pc: 