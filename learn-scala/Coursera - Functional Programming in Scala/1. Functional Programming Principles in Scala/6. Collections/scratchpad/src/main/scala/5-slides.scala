package mod6_slides5

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
        // println(splitNumIndex) 
        // println(candidateWord)
        // println(remainder)
        candidateWord :: remainder
  }

@main def code(number: String) =
  val coder = Coder(List(
    "Scala", "Python", "Ruby", "C",
    "rocks", "socks", "sucks", "works", "pack", "suaks"
  ))
  println(coder.mapEncodingNumberToCandidateString)
  
  val tmp = coder.decodeAllPossibleString(number)
  println(tmp)
  println(tmp.map(_.mkString(" ")))
  