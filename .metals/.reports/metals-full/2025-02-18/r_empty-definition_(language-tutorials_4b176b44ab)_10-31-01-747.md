error id: file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/6.%20Collections/scratchpad/src/main/scala/4-slides.scala:66
file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/6.%20Collections/scratchpad/src/main/scala/4-slides.scala
empty definition using pc, found symbol in pc: 
semanticdb not found
|empty definition using fallback
non-local guesses:
	 -

Document text:

```scala
package mod6_slides4

val capitalOfCountry = Map("US" -> "Washington", "Switzerland" -> "Bern")
val l = List(10,2,3,4,5)

def reverseMap(capitalMap: Map[String, String]): Map[String, String] = {
  capitalMap.map((x,y) => (y,x))
}

def showCapital(capitalMap: Map[String,String], country: String): String = {
  capitalMap(country)
}

def showCapital2(capitalMap: Map[String,String], country: String): Option[String] = {
  capitalMap.get(country)
}

def showCapital3(capitalMap: Map[String,String], country: String): String = {
  capitalMap.get(country) match
    case Some(capital) =>  capital
    case None => "WTF?"
}

def updateMap[K, V](map: Map[K, V], updateTup: (K, V)): Map[K, V] = {
  map + updateTup
}

def mergeMap[K, V](map: Map[K, V], newMap: Map[K,V]): Map[K, V] = {
  map ++ newMap
}

class Polynomial(nonZeroTerms: Map[Int, Int]):
  
  //alternative constructor
  def this(polynomialCoefficients: (Int, Int)*) = this(polynomialCoefficients.toMap)

  def terms = nonZeroTerms.withDefaultValue(0)

  // Using concatenation of keySet to define `+`
  def `+v1`(other: Polynomial): Polynomial = {
    Polynomial(
      (this.terms.keySet ++ other.terms.keySet)
      .map(
        key => (key, this.terms.getOrElse(key, 0)+other.terms.getOrElse(key, 0))
      )
      .toMap
    )
  }

  // Using Map concatenation to define `+`
  def `+v2`(other: Polynomial): Polynomial = {
    /* for everything that exists only in `this.terms`, it will remain in the new Map. else, if exists in both, it will be overwritten by the sum of coefficients */
    Polynomial(
      this.terms ++ other.terms.map((exp,coeff) => (exp, coeff+this.terms(exp)))
    )
  }

  // Using foldLeft to define `+`
  def `+v3`(other: Polynomial): Polynomial = {
    Polynomial(
      this.terms.foldLeft(other.terms)((otherMap, (thisKey, thisValue)) => {
        
      })
      
      // {
      //   case (otherMap, (thisKey, thisValue)) => {
      //     otherMap.updated(thisKey, otherMap.getOrElse(thisKey, 0) + thisValue)
      //   }
      // }
    )
  }

  override def toString = {
    val stringRepresentation = {
      for (exp, coeff) <- this.terms.toList.sorted.reverse
      yield
        s"${coeff}x^${exp}"
    }
    if !stringRepresentation.isEmpty then stringRepresentation.mkString(" + ")
    else ""
  }

@main def main() = {
  println(reverseMap(capitalOfCountry)) //reverse Map

  println(showCapital(capitalOfCountry, "US")) //get capital using bracket notation
  println(showCapital2(capitalOfCountry, "US")) //get capital using `get`

  //println(showCapital(capitalOfCountry, "Singapore")) //throws error if missing key
  println(showCapital2(capitalOfCountry, "Singapore")) //returns None if missing key
  println(showCapital3(capitalOfCountry, "Singapore")) //returns custom value if missing key

  println(updateMap(capitalOfCountry, ("Singapore", "Singapore"))) //add new key
  println(updateMap(capitalOfCountry, ("US", "Miami"))) //update existing key
  println(mergeMap(capitalOfCountry, Map("US" -> "Miami", "Singapore" -> "Singapore"))) //merge 2 maps

  println(l.sorted) //sort a list using default ascending sort
  println(l.sortWith((x,y) => x % 2 < y % 2)) //sort a list using custom sort
  println(l.groupBy(x => x % 2 == 0)) //group list to map

  println((Polynomial(Map(0 -> 1, 2 -> 2)) `+v1` Polynomial(Map(1 -> 2, 2 -> 4))).toString)
  println((Polynomial((0,1),(2,2)) `+v1` Polynomial((1,2),(2,4))).toString) //can also use alt constructor of (Int, Int)*
  println((Polynomial((0,1),(2,2)) `+v2` Polynomial((1,2),(2,4))).toString) //all implementations of `+` work as expected
  println((Polynomial((0,1),(2,2)) `+v3` Polynomial((1,2),(2,4))).toString)

}
```

#### Short summary: 

empty definition using pc, found symbol in pc: 