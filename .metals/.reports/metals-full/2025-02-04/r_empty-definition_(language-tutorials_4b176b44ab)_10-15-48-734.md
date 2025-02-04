error id: MyTrue
file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/3.%20Data%20and%20Abstraction/scratchpad/src/main/scala/4-slides.scala
empty definition using pc, found symbol in pc: 
semanticdb not found
found definition using fallback; symbol MyTrue
Document text:

```scala
package mod3_slides4

abstract class MyBoolean:
  def ifThenElse[T](t: => T, e: => T): T 
  
  def && (x: => MyBoolean): MyBoolean = ifThenElse(x, false) //MyTrue.ifThenElse(true, false) = true
  def || (x: => MyBoolean): MyBoolean = ifThenElse(true, x)
  def my_! : MyBoolean = ifThenElse(false, true)

  def == (x: => MyBoolean): MyBoolean = ifThenElse()

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
```

#### Short summary: 

empty definition using pc, found symbol in pc: 