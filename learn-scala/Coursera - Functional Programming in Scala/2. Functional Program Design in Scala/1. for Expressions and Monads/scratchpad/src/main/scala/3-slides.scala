package mod1_slides3

val l = List(1,2,3,4)

def func(x: Any): List[Any] = {
  println(List(x))
  List(x)
}

def flatMap[T, U](xs: List[T], f: T => Iterable[U]): List[U] = {
  for 
    x <- xs 
    y <- f(x)
  yield 
    y
}

case class Book(title: String, authors: List[String])

val books: List[Book] = List(
  Book(
    title = "Structure and Interpretation of Computer Programs",
    authors = List("Abelson, Harald", "Sussman, Gerald J.")
  ),
  Book(
    title = "Introduction to Functional Programming",
    authors = List("Bird, Richard", "Wadler, Phil")
    ),
  Book(
    title = "Effective Java",
    authors = List("Bloch, Joshua")
  ),
  Book(
    title = "some crap",
    authors = List("Bloch, Joshua")
  ),
  Book(
    title = "Java Puzzlers",
    authors = List("Bloch, Joshua", "Gafter, Neal")
  ),
  Book(
    title = "Programming in Scala",
    authors = List("Odersky, Martin", "Spoon, Lex", "Venners, Bill")
  )
)

def f1() = {
  val a = {
    for 
      b <- books 
      a <- b.authors 
      if a.startsWith("Bird")
    yield b.title
  }
  println(a)
}

def f2() = {
  val a = {
    books.flatMap(b =>
      b.authors
      .filter(a => a.startsWith("Bird"))
      // .withFilter(a => a.startsWith("Bird"))
      .map(a => b.title)
    )
  }
  println(a)
}

def f3() = {
  val a = {
    books.map(b =>
      b.authors
      .map(a => if a.startsWith("Bird") then b.title else None)
      .filter(x => x != None)
    )
    .flatten
  }
  println(a)
}

@main def main() = {
  f1()
  f2()
  f3()
}

