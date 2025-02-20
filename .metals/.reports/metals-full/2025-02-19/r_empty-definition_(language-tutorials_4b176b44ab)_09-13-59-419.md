error id: forcomp/
file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/6.%20Collections/assignments/forcomp/src/main/scala/forcomp/AnagramsInterface.scala
empty definition using pc, found symbol in pc: forcomp/
semanticdb not found
|empty definition using fallback
non-local guesses:
	 -

Document text:

```scala
package forcomp

/**
 * The interface used by the grading infrastructure. Do not change signatures
 * or your submission will fail with a NoSuchMethodError.
 */
trait AnagramsInterface:
  def wordOccurrences(w: String): List[(Char, Int)]
  def sentenceOccurrences(s: List[String]): List[(Char, Int)]
  def dictionaryByOccurrences: Map[List[(Char, Int)], List[String]]
  def wordAnagrams(word: String): List[String]
  def combinations(occurrences: List[(Char, Int)]): List[List[(Char, Int)]]
  def subtract(x: List[(Char, Int)], y: List[(Char, Int)]): List[(Char, Int)]
  def sentenceAnagrams(sentence: List[String]): List[List[String]]

```

#### Short summary: 

empty definition using pc, found symbol in pc: forcomp/