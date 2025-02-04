error id: Zero
file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/3.%20Data%20and%20Abstraction/scratchpad/src/main/scala/4-slides.scala
empty definition using pc, found symbol in pc: 
semanticdb not found
found definition using fallback; symbol Zero
Document text:

```scala
package mod3_slides4

abstract class MyBoolean:
  def ifThenElse[T](t: => T, e: => T): T 
  
  def && (x: => MyBoolean): MyBoolean = ifThenElse(x, MyFalse) //MyTrue.ifThenElse(true, false) = true
  def || (x: => MyBoolean): MyBoolean = ifThenElse(MyTrue, x)
  def my_! : MyBoolean = ifThenElse(MyFalse, MyTrue)

  def == (x: => MyBoolean): MyBoolean = ifThenElse(x, x.my_!)
  def != (x: => MyBoolean): MyBoolean = ifThenElse(x.my_!, x)

  def ==> (x: MyBoolean): MyBoolean = {
    /*
      True,True --> True
      True,False --> False
      False,True --> True
      False,False --> True
    */
    ifThenElse(x, MyTrue)
  }

object MyTrue extends MyBoolean:
  def ifThenElse[T](then_returnval: => T, else_returnval: => T): T = {
    /*
      MyTrue.iftenElse(t, e) = t
    */
    then_returnval
  }

object MyFalse extends MyBoolean:
  def ifThenElse[T](then_returnval: => T, else_returnval: => T): T = {
    /*
      MyFalse.iftenElse(t, e) = e
    */
    else_returnval
  }

//================================================

abstract class NaturalNum:
  def isZero: Boolean
  def predecessor: NaturalNum
  def successor: NaturalNum
  def + (that: NaturalNum): NaturalNum
  def - (that: NaturalNum): NaturalNum
end NaturalNum

object Zero extends NaturalNum:
  def isZero: Boolean = {
    true
  }

  def predecessor: NaturalNum = {
    ???
  }

  def successor: NaturalNum = {
    Successor(this)
  }

  def + (that: NaturalNum): NaturalNum = {
    that
  }

  def - (that: NaturalNum): NaturalNum = {
    if that.isZero then this else ???
  }

  override def toString = {
    "Zero"
  }

class Successor(n: NaturalNum) extends NaturalNum:
  def isZero: Boolean = {
    false
  }

  def predecessor: NaturalNum = {
    n
  }

  def successor: NaturalNum = {
    Successor(this)
  }

  def + (that: NaturalNum): NaturalNum = {
    Successor(n + that)
  }

  def - (that: NaturalNum): NaturalNum = {
    if that.isZero then this else n - that.predecessor
  }

  override def toString = {
    s"Succ(${n})"
  }

@main def main() = {
  println(Zero)
  println(Successor(Zero))
  println(Successor(Successor(Zero)))

  val two = Successor(Successor(Zero))
  val one = Successor(Zero)
  println(two + one)
}
```

#### Short summary: 

empty definition using pc, found symbol in pc: 