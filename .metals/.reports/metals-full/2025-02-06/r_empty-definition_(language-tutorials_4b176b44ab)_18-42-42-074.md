error id: mod4_slides4/
file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/4.%20Types%20and%20Pattern%20Matching/scratchpad/src/main/scala/4-slides.scala
empty definition using pc, found symbol in pc: mod4_slides4/
semanticdb not found
|empty definition using fallback
non-local guesses:
	 -

Document text:

```scala
package mod4_slides4

enum Direction(val dx: Int, val dy: Int):
  case Right extends Direction( 1, 0)
  case Up extends Direction(0, 1)
  case Left extends Direction(-1, 0)
  case Down extends Direction( 0, -1)
  
  def leftTurn = Direction.values((ordinal + 1) % 4)
end Direction

val r = Direction.Right
val u = r.leftTurn // u = Up
val v = (u.dx, u.dy) // v = (1, 0)

@main def main() = {
  println(r.leftTurn)
}
```

#### Short summary: 

empty definition using pc, found symbol in pc: mod4_slides4/