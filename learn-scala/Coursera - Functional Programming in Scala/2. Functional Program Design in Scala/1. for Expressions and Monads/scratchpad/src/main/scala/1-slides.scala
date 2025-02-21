package mod1_slides1

abstract class JSON:
  //def abstractMethod: Unit  //must be implemented by subclasses
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

val jsData = JSON2._Obj(Map(
  "firstName" -> JSON2._Str("John"),
  "lastName" -> JSON2._Str("Smith"),
  "address" -> JSON2._Obj(Map(
    "streetAddress" -> JSON2._Str("21 2nd Street"),
    "state" -> JSON2._Str("NY"),
    "postalCode" -> JSON2._Num(10021)
  )),
  "phoneNumbers" -> JSON2._Seq(List(
    JSON2._Obj(Map(
      "type" -> JSON2._Str("home"), 
      "number" -> JSON2._Str("212 555-1234")
    )),
    JSON2._Obj(Map(
      "type" -> JSON2._Str("fax"), 
      "number" -> JSON2._Str("646 555-4567")
    )) 
  )) 
))

def bindings(x: JSON2): List[(String, JSON2)] = {
  x match
    case JSON2._Obj(bindings) => bindings.toList
    case _ => Nil
}

@main def main() = {
  for
    case ("phoneNumbers", JSON2._Seq(numberInfos)) <- bindings(jsData)
    numberInfo <- numberInfos
    case ("number", JSON2._Str(number)) <- bindings(numberInfo)
    if number.startsWith("212")
  yield
    println(bindings(jsData))
    println(numberInfos)
    println(bindings(numberInfo))
    println(number)
    number
}