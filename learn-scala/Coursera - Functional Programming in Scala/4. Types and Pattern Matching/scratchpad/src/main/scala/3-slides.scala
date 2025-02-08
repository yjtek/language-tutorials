package mod4_slides3

val test = List(1,2,3,4,5)

def isort(xs: List[Int]): List[Int] = xs match
  case List() => List()
  case y :: ys => insert(y, isort(ys))

def insert(x: Int, xs: List[Int]): List[Int] = xs match
  case List() => List(x) // if xs is empty, then just create a new list and include x
  
  /* if xs is not empty, then it is more complex, because we need to express this recursively
      - the expression y :: ys checks that xs is a non-empty list, and splits it into the constituent head (y) and tail-list (ys)
      - if the element to insert (x) is <= than the head of the list y, we can simply insert it to the head of the list xs
      - if the element to insert (x) is larger than the head of the list
        - recursively `insert` x into the tail of xs (since you already know it is larger than y)

    Let's step through an example; imagine we call isort(List(1,3,4,2))
      - insert(1, isort(List(3,4,2)))
        - insert(3, isort(List(4,2)))
          - insert(4, isort(List(2)))
            - insert(2, isort(List()))
            - insert(2, List())
          - insert(4, List(2))
            - 2 :: insert(4, List())
            - 2 :: List(4)
            - List(2,4)
        - insert(3, List(2,4))
          - 2 :: insert(3, List(4))
          - 2 :: List(3,4)
        - List(2,3,4)
      - insert(1, List(2,3,4))
      - List(1,2,3,4)
  */
  case y :: ys => 
    if x <= y then x :: xs
    else y :: insert(x, ys)
    
@main def main() = {
  println((List("2", "ABCDE") :: Nil :: List(1, 3) :: Nil).size)
  println(isort(List(1,3,4,2)))
}