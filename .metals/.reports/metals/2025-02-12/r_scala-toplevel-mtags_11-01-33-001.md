error id: file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/5.%20Lists/scratchpad/src/main/scala/1-slides.scala:[26..27) in Input.VirtualFile("file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/5.%20Lists/scratchpad/src/main/scala/1-slides.scala", "package mod5_slides1

def [T]last(l: List[T]): T = {
  l match
    case Nil => throw new Error("empty list has no last element")
    case elem :: tail => last(tail)
    case List(x) => x
}

@main def main() = {
  ...
}")
file://<WORKSPACE>/file:<WORKSPACE>/learn-scala/Coursera%2520-%2520Functional%2520Programming%2520in%2520Scala/5.%2520Lists/scratchpad/src/main/scala/1-slides.scala
file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/5.%20Lists/scratchpad/src/main/scala/1-slides.scala:3: error: expected identifier; obtained lbracket
def [T]last(l: List[T]): T = {
    ^
#### Short summary: 

expected identifier; obtained lbracket