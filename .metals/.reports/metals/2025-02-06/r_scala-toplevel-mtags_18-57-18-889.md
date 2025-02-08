error id: file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/4.%20Types%20and%20Pattern%20Matching/scratchpad/src/main/scala/5-slides.scala:[29..34) in Input.VirtualFile("file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/4.%20Types%20and%20Pattern%20Matching/scratchpad/src/main/scala/5-slides.scala", "package mod4_slides5

class 
class NonEmpty {}
class Empty {}


val a: Array[NonEmpty] = Array(NonEmpty(1, Empty(), Empty()))
val b: Array[IntSet] = a
b(0) = Empty()
val s: NonEmpty = a(0)")
file://<WORKSPACE>/file:<WORKSPACE>/learn-scala/Coursera%2520-%2520Functional%2520Programming%2520in%2520Scala/4.%2520Types%2520and%2520Pattern%2520Matching/scratchpad/src/main/scala/5-slides.scala
file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/4.%20Types%20and%20Pattern%20Matching/scratchpad/src/main/scala/5-slides.scala:4: error: expected identifier; obtained class
class NonEmpty {}
^
#### Short summary: 

expected identifier; obtained class