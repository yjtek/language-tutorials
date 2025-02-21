package learn$minusscala.Coursera$u0020$minus$u0020Functional$u0020Programming$u0020in$u0020Scala.`1$u002E$u0020Functional$u0020Programming$u0020Principles$u0020in$u0020Scala`.`1$u002E$u0020Getting$u0020Started`.`1$minusgetting$minusstarted`.scala$minusproject.src.main.scala.example


final class example$u002Eworksheet$_ {
def args = example$u002Eworksheet_sc.args$
def scriptPath = """learn-scala/Coursera - Functional Programming in Scala/1. Functional Programming Principles in Scala/1. Getting Started/1-getting-started/scala-project/src/main/scala/example/example.worksheet.sc"""
/*<script>*/
1 + 1

val x = 42

x * x

5 * 5
/*</script>*/ /*<generated>*//*</generated>*/
}

object example$u002Eworksheet_sc {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new example$u002Eworksheet$_

  def main(args: Array[String]): Unit = {
    args$set(args)
    val _ = script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export example$u002Eworksheet_sc.script as `example.worksheet`

