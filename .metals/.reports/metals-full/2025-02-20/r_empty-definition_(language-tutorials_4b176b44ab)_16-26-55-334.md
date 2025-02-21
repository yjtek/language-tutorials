error id: file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/2.%20Functional%20Program%20Design%20in%20Scala/1.%20for%20Expressions%20and%20Monads/scratchpad/src/main/scala/1-slides.scala:31
file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/2.%20Functional%20Program%20Design%20in%20Scala/1.%20for%20Expressions%20and%20Monads/scratchpad/src/main/scala/1-slides.scala
empty definition using pc, found symbol in pc: 
semanticdb not found
|empty definition using fallback
non-local guesses:
	 -JSON2.
	 -scala/Predef.JSON2.

Document text:

```scala
package mod1_slides1

abstract class JSON:
  def abstractMethod: Nil 
  val a: Int = 123 //inherited

object JSON:
  case class _Seq (elems: List[JSON]) extends JSON
  case class _Obj (bindings: Map[String, JSON]) extends JSON
  case class _Num (num: Double) extends JSON
  case class _Str (str: String) extends JSON
  case class _Bool(b: Boolean) extends JSON
  case object _Null extends JSON

  def abstractClassMethod() = {
    println("call using JSON.abstractClassMethod()")
  }

enum JSON2:
  case _Seq (elems: List[JSON2])
  case _Obj (bindings: Map[String, JSON2])
  case _Num (num: Double)
  case _Str (str: String)
  case _Bool(b: Boolean)
  case _Null

val jsData = JSON.Obj(Map(
  "firstName" -> JSON.Str("John"),
  "lastName" -> JSON.Str("Smith"),
  "address" -> JSON.Obj(Map(
    "streetAddress" -> JSON.Str("21 2nd Street"),
    "state" -> JSON.Str("NY"),
    "postalCode" -> JSON.Num(10021)
  )),
  "phoneNumbers" -> JSON.Seq(List(
    JSON.Obj(Map(
      "type" -> JSON.Str("home"), 
      "number" -> JSON.Str("212 555-1234")
    )),
    JSON.Obj(Map(
      "type" -> JSON.Str("fax"), 
      "number" -> JSON.Str("646 555-4567")
    )) 
  )) 
))

@main def main() = {

}
```

#### Short summary: 

empty definition using pc, found symbol in pc: 