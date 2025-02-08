error id: scala/collection/mutable/
file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/4.%20Types%20and%20Pattern%20Matching/scratchpad/src/main/scala/5-slides.scala
empty definition using pc, found symbol in pc: scala/collection/mutable/
semanticdb not found
|empty definition using fallback
non-local guesses:
	 -

Document text:

```scala
package mod4_slides5

import scala.collection.mutable.ArrayBuffer

// Type bounds

class SuperClass {
  ???
}

class SubClass extends SuperClass {
  ???
}

class AnotherClass {
  ???
}

def func(param1: SubClass): Option[String] = {
  ???
}

@main def main() = {
  val test1 = SuperClass()
  val test2 = SubClass()
  val test3 = AnotherClass()

  func(test1)
  func(test2)
  func(test3)
}

// ==========================================
```

#### Short summary: 

empty definition using pc, found symbol in pc: scala/collection/mutable/