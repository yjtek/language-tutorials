error id: file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/6.%20Collections/assignments/forcomp/src/main/scala/forcomp/Anagrams.scala:163
file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/6.%20Collections/assignments/forcomp/src/main/scala/forcomp/Anagrams.scala
empty definition using pc, found symbol in pc: 
semanticdb not found
|empty definition using fallback
non-local guesses:
	 -k.
	 -k#
	 -k().
	 -scala/Predef.k.
	 -scala/Predef.k#
	 -scala/Predef.k().

Document text:

```scala
package forcomp

import scala.io.{ Codec, Source }

object Anagrams extends AnagramsInterface:

  /** A word is simply a `String`. */
  type Word = String

  /** A sentence is a `List` of words. */
  type Sentence = List[Word]

  /** `Occurrences` is a `List` of pairs of characters and positive integers saying
   *  how often the character appears.
   *  This list is sorted alphabetically w.r.t. to the character in each pair.
   *  All characters in the occurrence list are lowercase.
   *
   *  Any list of pairs of lowercase characters and their frequency which is not sorted
   *  is **not** an occurrence list.
   *
   *  Note: If the frequency of some character is zero, then that character should not be
   *  in the list.
   */
  type Occurrences = List[(Char, Int)]

  /** The dictionary is simply a sequence of words.
   *  It is predefined and obtained as a sequence using the utility method `loadDictionary`.
   */
  val dictionary: List[Word] = Dictionary.loadDictionary

  /** Converts the word into its character occurrence list.
   *
   *  Note: the uppercase and lowercase version of the character are treated as the
   *  same character, and are represented as a lowercase character in the occurrence list.
   *
   *  Note: you must use `groupBy` to implement this method!
   */
  def wordOccurrences(w: Word): Occurrences = {
    w.toLowerCase.groupBy(x => x).view.mapValues(x => x.length).toList.sorted
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
    .view
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

  /** The `dictionaryByOccurrences` is a `Map` from different occurrences to a sequence of all
   *  the words that have that occurrence count.
   *  This map serves as an easy way to obtain all the anagrams of a word given its occurrence list.
   *
   *  For example, the word "eat" has the following character occurrence list:
   *
   *     `List(('a', 1), ('e', 1), ('t', 1))`
   *
   *  Incidentally, so do the words "ate" and "tea".
   *
   *  This means that the `dictionaryByOccurrences` map will contain an entry:
   *
   *    List(('a', 1), ('e', 1), ('t', 1)) -> Seq("ate", "eat", "tea")
   *
   */
  lazy val dictionaryByOccurrences: Map[Occurrences, List[Word]] = {
    val l: List[(Word, Occurrences)] = dictionary.map(x => (x, wordOccurrences(x)))
    
    l
    .groupBy((word, occ) => occ)
    .view
    .mapValues(
      listOfWordOccTups => {
        listOfWordOccTups.foldLeft(List[Word]()){
          case (acc, (word,occ)) => acc :+ word//.toLowerCase
        }
      }
    )
    .toMap
    .withDefaultValue(Nil)
  }

  /** Returns all the anagrams of a given word. */
  def wordAnagrams(word: Word): List[Word] = {
    val l: List[Word] = dictionaryByOccurrences(wordOccurrences(word))
    l //.filter(x => x != word)
  }

  /** Returns the list of all subsets of the occurrence list.
   *  This includes the occurrence itself, i.e. `List(('k', 1), ('o', 1))`
   *  is a subset of `List(('k', 1), ('o', 1))`.
   *  It also include the empty subset `List()`.
   *
   *  Example: the subsets of the occurrence list `List(('a', 2), ('b', 2))` are:
   *
   *    List(
   *      List(),
   *      List(('a', 1)),
   *      List(('a', 2)),
   *      List(('b', 1)),
   *      List(('a', 1), ('b', 1)),
   *      List(('a', 2), ('b', 1)),
   *      List(('b', 2)),
   *      List(('a', 1), ('b', 2)),
   *      List(('a', 2), ('b', 2))
   *    )
   *
   *  Note that the order of the occurrence list subsets does not matter -- the subsets
   *  in the example above could have been displayed in some other order.
   */
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

  /** Subtracts occurrence list `y` from occurrence list `x`.
   *
   *  The precondition is that the occurrence list `y` is a subset of
   *  the occurrence list `x` -- any character appearing in `y` must
   *  appear in `x`, and its frequency in `y` must be smaller or equal
   *  than its frequency in `x`.
   *
   *  Note: the resulting value is an occurrence - meaning it is sorted
   *  and has no zero-entries.
   */
  def subtract(x: Occurrences, y: Occurrences): Occurrences = {
    // val (p1,p2) = x.partition(a => y.exists(b => a._1 == b._1))
    // val diffed = for( (a,b) <- p1.zip(y) if a._2 != b._2) yield (a._1,a._2-b._2)
    // (p2 ++ diffed).sorted

    val yMap = y.toMap
    val xMap = x.toMap

    xMap
    .map(
      (k,v) => (k, v-yMap.getOrElse(k,0))
    )
    .toList
    // .filter((char,count) => count > 0)
  }

  /** Returns a list of all anagram sentences of the given sentence.
   *
   *  An anagram of a sentence is formed by taking the occurrences of all the characters of
   *  all the words in the sentence, and producing all possible combinations of words with those characters,
   *  such that the words have to be from the dictionary.
   *
   *  The number of words in the sentence and its anagrams does not have to correspond.
   *  For example, the sentence `List("I", "love", "you")` is an anagram of the sentence `List("You", "olive")`.
   *
   *  Also, two sentences with the same words but in a different order are considered two different anagrams.
   *  For example, sentences `List("You", "olive")` and `List("olive", "you")` are different anagrams of
   *  `List("I", "love", "you")`.
   *
   *  Here is a full example of a sentence `List("Yes", "man")` and its anagrams for our dictionary:
   *
   *    List(
   *      List(en, as, my),
   *      List(en, my, as),
   *      List(man, yes),
   *      List(men, say),
   *      List(as, en, my),
   *      List(as, my, en),
   *      List(sane, my),
   *      List(Sean, my),
   *      List(my, en, as),
   *      List(my, as, en),
   *      List(my, sane),
   *      List(my, Sean),
   *      List(say, men),
   *      List(yes, man)
   *    )
   *
   *  The different sentences do not have to be output in the order shown above - any order is fine as long as
   *  all the anagrams are there. Every returned word has to exist in the dictionary.
   *
   *  Note: in case that the words of the sentence are in the dictionary, then the sentence is the anagram of itself,
   *  so it has to be returned in this list.
   *
   *  Note: There is only one anagram of an empty sentence.
   */
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

    def recur(occ: Occurrences, iter: Int): List[Sentence] = {
      println(s"""${"  "*iter}Processing occurrences: $occ""")
      if occ.isEmpty then {
        println(s"""${"  "*iter}Base case hit, returning List(Nil)""")
        List(Nil)
      }
      else {
        val subsets = combinations(occ).filter(_.nonEmpty)
        println(s"""${"  "*iter}Generated subsets: $subsets""")
        
        for 
          subset <- subsets
          word <- dictionaryByOccurrences.getOrElse(subset, Nil)
          tailAnagrams <- recur(subtract(occ, subset), iter+1)
        yield
          println(s"""${"  "*iter}subset: $subset""")
          println(s"""${"  "*iter}word: $word""")
          println(s"""${"  "*iter}subtract(occ, subset): $subtract(occ, subset)""")
          println(s"""${"  "*iter}tailAnagrams: $tailAnagrams""")
          println(s"""${"  "*iter}word :: tailAnagrams: ${word :: tailAnagrams}""")
          word :: tailAnagrams
      }
    }

    recur(sentenceOccurrences(sentence), 0)
  }

object Dictionary:
  def loadDictionary: List[String] =
    val wordstream = Option {
      getClass.getResourceAsStream(List("forcomp", "linuxwords.txt").mkString("/", "/", ""))
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

@main def main() = {
  val s: Anagrams.Sentence = List("this", "is", "a", "string")
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

  // println(Anagrams.sentenceAnagrams(List("a", "b", "c", "d")))
  println(Anagrams.sentenceAnagrams(List("i", "am", "g")))
}
```

#### Short summary: 

empty definition using pc, found symbol in pc: 