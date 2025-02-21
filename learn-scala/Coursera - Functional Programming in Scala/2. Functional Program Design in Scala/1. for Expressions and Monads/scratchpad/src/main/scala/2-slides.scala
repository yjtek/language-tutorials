package mod1_slides2

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

def allAuthorsWithMultiplebooks_attempt1() = {
  /* 
    first attempt, use b1.title < b2.title to avoid comparing b1,b2 and b2,b1 as separate cases 
    however, adding a third book makes us compare 3 times still (because 6 possible comparisons)
  */
  val a = {
    for
      b1 <- books
      b2 <- books
      if b1.title < b2.title
      a1 <- b1.authors
      a2 <- b2.authors
      if a1 == a2
    yield
      println(b1.title)
      println(b2.title)
      a1
  }
  println(a)
}

def allAuthorsWithMultiplebooks_attempt2() = {
  /* dealing with duplicates */
  val a = {
    for
      b1 <- books
      b2 <- books
      if b1.title < b2.title
      a1 <- b1.authors
      a2 <- b2.authors
      if a1 == a2
    yield
      a1
  }
  println(a.distinct)
}

def allAuthorsWithMultiplebooks_attempt3() = {
  /* For loop will collect into an iterable based on the first input, which in this case is a set*/
  val bookSet = books.toSet
  val a = {
    for
      b1 <- bookSet
      b2 <- bookSet
      if b1 != b2
      a1 <- b1.authors
      a2 <- b2.authors
      if a1 == a2
    yield 
      a1
  }
  println(a)
}

@main def main() = {
  // allAuthorsWithMultiplebooks_attempt1()
  // allAuthorsWithMultiplebooks_attempt2()
  allAuthorsWithMultiplebooks_attempt3()
}

