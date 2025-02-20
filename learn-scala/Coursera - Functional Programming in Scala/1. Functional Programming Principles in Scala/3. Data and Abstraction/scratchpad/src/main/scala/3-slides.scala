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
