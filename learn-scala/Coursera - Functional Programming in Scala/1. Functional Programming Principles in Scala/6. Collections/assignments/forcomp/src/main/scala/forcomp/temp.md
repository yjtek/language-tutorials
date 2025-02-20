package forcomp

import scala.io.{ Codec, Source }

type Word = String
type Sentence = List[Word]
type Occurrences = List[(Char, Int)]

object Dictionary2:
  def loadDictionary2: List[String] = {
    val source = Source.fromFile("/Users/yongjian.tek/Desktop/language-tutorials/learn-scala/Coursera - Functional Programming in Scala/6. Collections/assignments/forcomp/src/main/resources/forcomp/linuxwords.txt")  // Adjust the relative path
    val words = source.getLines().toList
    source.close()
    words
  }

  def loadDictionary: List[String] =
    val wordstream = Option {
      getClass.getResourceAsStream(List("forcomp", "linuxwords.txt").mkString("/", "/", ""))
      // getClass.getResourceAsStream("../../../resources/forcomp/linuxwords.txt")
    } getOrElse {
      sys.error("Could not load word list, dictionary file not found")
    }
    try
      val s = Source.fromInputStream(wordstream)(Codec.UTF8)
      s.getLines().toList
    catch
      case e: Exception =>
        println("Could not load word list: " + e)
        throw e
    finally
      wordstream.close()

val dictionary: List[Word] = Dictionary2.loadDictionary2

def wordOccurrences(w: Word): Occurrences = {
  w.groupBy(x => x).mapValues(x => x.length).toList.sorted
}

/** Converts a sentence into its character occurrence list. */
def sentenceOccurrences(s: Sentence): Occurrences = {
  val tmp: Occurrences = {
    s match 
      case word :: tail => {
        wordOccurrences(word) ++ sentenceOccurrences(tail)
      }
      case Nil => List()
    }
  
  tmp
  .groupBy((x,y)=>x)
  .mapValues(
    l => {
      l.foldLeft(0){
        case (acc, (char,count)) => acc + count
      }
    }
  )
  .toList
  .sorted
}

lazy val dictionaryByOccurrences: Map[Occurrences, List[Word]] = {
  val l: List[(Word, Occurrences)] = dictionary.map(x => (x, wordOccurrences(x)))
  
  l
  .groupBy((word, occ) => occ)
  .mapValues(
    listOfWordOccTups => {
      listOfWordOccTups.foldLeft(List[Word]()){
        case (acc, (word,occ)) => acc :+ word
      }
    }
  )
  .toMap
  .withDefaultValue(Nil)
}

def wordAnagrams(word: Word): List[Word] = {
  val l: List[Word] = dictionaryByOccurrences(wordOccurrences(word))
  l.filter(x => x != word)
}

def combinations(occurrences: Occurrences): List[Occurrences] = {
  occurrences match
    case Nil => List(Nil)
    case (char, count) :: tail => {
      val tailCombination: List[Occurrences] = combinations(tail)
      val tailCombinationWithHead: List[Occurrences] = {
        for
          candidateCount: Int <- (1 to count).toList
          candidateTailCombination: Occurrences <- tailCombination
        yield
          (char,candidateCount) :: candidateTailCombination
      }

      tailCombination ++ tailCombinationWithHead
    }
}

def subtract(x: Occurrences, y: Occurrences): Occurrences = {
  val yMap = y.toMap.withDefaultValue(0)
  val xMap = x.toMap

  val canSubtract: Boolean = yMap.keySet
  .forall(
    yk => {
      xMap.getOrElse(yk,0) >= yMap(yk)
    }
  )

  if !canSubtract then Nil
  else
    xMap
    .map(
      (k,v) => (k, v-yMap.getOrElse(k,0))
    )
    .toList
    .filter((char,count) => count > 0)
}

def sentenceAnagrams(sentence: Sentence): List[Sentence] = {
  /*
    receive List[String]
    convert to List[(Char, Int)]
    generate all possible subsets of List[(Char, Int)]
    for each subset, it is possible to have multiple words. Use `dictionaryByOccurrences` to lookup possible words for a given subset of Occurrences
    for each word, subtract the wordOccurrence from sentenceOccurence, and recursively run `sentenceAnagrams`
    then yield the word joined with the anagrams generated from the subtraction

    In base case, imagine with have something like List(('a', 1)).
      - This create only 2 subsets List(('a',1)), and List()
        - `List()` 
          - Has no words in dictionary, so will return Nil
        - List(('a', 1))
          - Has 1 word in dictionary `a`
          - subtracting this will give us List(), which recursively returns Nil()
          - So we yield a :: Nil which gives us List('a')
  */

  def recur(occ: Occurrences): List[Sentence] = {
    // println(s"Processing occurrences: $occ")
    if occ.isEmpty then {
      // println("Base case hit, returning List(Nil)")
      List(Nil)
    }
    else {
      val subsets = combinations(occ).filter(_.nonEmpty)
      // println(s"Generated subsets: $subsets")
      
      for 
        subset <- subsets
        word <- dictionaryByOccurrences.getOrElse(subset, Nil)
        tailAnagrams <- recur(subtract(occ, subset))
      yield
        word :: tailAnagrams
    }
  }

  recur(sentenceOccurrences(sentence))
}

@main def main() = {
  val s: Sentence = List("this", "is", "a", "string")
  // println(wordOccurrences("abcaa"))
  // println(sentenceOccurrences(s))
  // println(dictionaryByOccurrences.take(2))
  // println(combinations(List(('a',2), ('b',2))))
  // println(subtract(List(('a', 2), ('b',2)), List(('a',2))))
  // println(sentenceAnagrams(s))
  
  // println(sentenceOccurrences(List("yes", "man")))
  // println(combinations(List(('a', 2), ('b', 1))))
  // println(dictionaryByOccurrences(List(('a', 1))))
  // println(subtract(List(('a', 2), ('b', 1)), List(('a', 1))))
  // println(sentenceAnagrams(List("yes", "man")))
  // println(sentenceAnagrams(List("this", "is", "a", "sentence")))

  
}