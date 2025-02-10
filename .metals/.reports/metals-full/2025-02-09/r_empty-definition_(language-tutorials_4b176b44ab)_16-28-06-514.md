error id: mod3_slides3/
file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/3.%20Data%20and%20Abstraction/scratchpad/src/main/scala/3-slides.scala
empty definition using pc, found symbol in pc: mod3_slides3/
semanticdb not found
|empty definition using fallback
non-local guesses:
	 -

Document text:

```scala
package mod3_slides3

trait LIST[T]:
  def isEmpty: Boolean
  def head: T
  def tail: LIST[T]

class CONS[T](val head: T, val tail: LIST[T]) extends LIST[T]:
  def isEmpty = false

class NIL[T] extends LIST[T]:
  def isEmpty = true
  def head = throw new NoSuchElementException("NIL[T].head")
  def tail = throw new NoSuchElementException("NIL[T].tail")

def nth[T](arr: LIST[T], n: Int): T = {
  if arr.isEmpty then throw new IndexOutOfBoundsException()
  else if n == 0 then arr.head
  else nth(arr.tail, n-1)
}

```

#### Short summary: 

empty definition using pc, found symbol in pc: mod3_slides3/