error id: file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/6.%20Collections/scratchpad/src/main/scala/5-slides.scala:[1059..1060) in Input.VirtualFile("file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/6.%20Collections/scratchpad/src/main/scala/5-slides.scala", "package mod6_slides5

class Coder(words: List[String]):
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
  
  def mapEncodingNumberToCandidateString: Map[String, List[String]] = {
    this.words.groupBy(wordToNumber).withDefaultValue(Nil)
  }

  def

  // /** All ways to encode a number as a list of words */
  // def encode(number: String): Set[List[String]] =
  //   if number.isEmpty then Set(Nil)
  //   else
  //     for
  //       splitPoint <- (1 to number.length).toSet
  //       word <- wordsForNum(number.take(splitPoint))
  //       rest <- encode(number.drop(splitPoint))
  //     yield word :: rest

// @main def code(number: String) =
@main def code() =
  val coder = Coder(List(
    "Scala", "Python", "Ruby", "C",
    "rocks", "socks", "sucks", "works", "pack"
  ))
  // println(coder.encode(number).map(_.mkString(" ")))
  println(coder.mapEncodingNumberToCandidateString())")
file://<WORKSPACE>/file:<WORKSPACE>/learn-scala/Coursera%2520-%2520Functional%2520Programming%2520in%2520Scala/6.%2520Collections/scratchpad/src/main/scala/5-slides.scala
file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/6.%20Collections/scratchpad/src/main/scala/5-slides.scala:40: error: expected identifier; obtained at
@main def code() =
^
#### Short summary: 

expected identifier; obtained at