error id: scala/io/
file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/6.%20Collections/assignments/forcomp/src/main/scala/forcomp/temp.scala
empty definition using pc, found symbol in pc: scala/io/
semanticdb not found
|empty definition using fallback
non-local guesses:
	 -

Document text:

```scala
package forcomp

import scala.io.{ Codec, Source }
type Sentence = List[String]

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

  Anagrams.sentenceAnagrams(List("Linux", "rulez"))
}
```

#### Short summary: 

empty definition using pc, found symbol in pc: scala/io/