file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/2.%20Higher%20Order%20Functions/assignments/funsets/src/main/scala/funsets/FunSets.scala
### java.lang.AssertionError: assertion failed

occurred in the presentation compiler.

presentation compiler configuration:


action parameters:
uri: file://<WORKSPACE>/learn-scala/Coursera%20-%20Functional%20Programming%20in%20Scala/2.%20Higher%20Order%20Functions/assignments/funsets/src/main/scala/funsets/FunSets.scala
text:
```scala
package funsets

/**
 * 2. Purely Functional Sets.
 */
trait FunSets extends FunSetsInterface:
  /**
   * We represent a set by its characteristic function, i.e.
   * its `contains` predicate.
   */
  override type FunSet = Int => Boolean

  /**
   * Indicates whether a set contains a given element.
   */
  def contains(s: FunSet, elem: Int): Boolean = s(elem)

  /**
   * Returns the set of the one given element.
   */
  def singletonSet(elem: Int): FunSet = {
    def returnFunSet(x" I) = {

    }
  }

  /**
   * Returns the union of the two given sets,
   * the sets of all elements that are in either `s` or `t`.
   */
  def union(s: FunSet, t: FunSet): FunSet = ???

  /**
   * Returns the intersection of the two given sets,
   * the set of all elements that are both in `s` and `t`.
   */
  def intersect(s: FunSet, t: FunSet): FunSet = ???

  /**
   * Returns the difference of the two given sets,
   * the set of all elements of `s` that are not in `t`.
   */
  def diff(s: FunSet, t: FunSet): FunSet = ???

  /**
   * Returns the subset of `s` for which `p` holds.
   */
  def filter(s: FunSet, p: Int => Boolean): FunSet = ???


  /**
   * The bounds for `forall` and `exists` are +/- 1000.
   */
  val bound = 1000

  /**
   * Returns whether all bounded integers within `s` satisfy `p`.
   */
  def forall(s: FunSet, p: Int => Boolean): Boolean =
    def iter(a: Int): Boolean =
      if ??? then
        ???
      else if ??? then
        ???
      else
        iter(???)
    iter(???)

  /**
   * Returns whether there exists a bounded integer within `s`
   * that satisfies `p`.
   */
  def exists(s: FunSet, p: Int => Boolean): Boolean = ???

  /**
   * Returns a set transformed by applying `f` to each element of `s`.
   */
  def map(s: FunSet, f: Int => Int): FunSet = ???

  /**
   * Displays the contents of a set
   */
  def toString(s: FunSet): String =
    val xs = for i <- (-bound to bound) if contains(s, i) yield i
    xs.mkString("{", ",", "}")

  /**
   * Prints the contents of a set on the console.
   */
  def printSet(s: FunSet): Unit =
    println(toString(s))

object FunSets extends FunSets

```



#### Error stacktrace:

```
scala.runtime.Scala3RunTime$.assertFailed(Scala3RunTime.scala:11)
	dotty.tools.dotc.parsing.Scanners$Scanner.lookahead(Scanners.scala:1090)
	dotty.tools.dotc.parsing.Parsers$Parser.termParamClause$$anonfun$1(Parsers.scala:3547)
	dotty.tools.dotc.parsing.Parsers$Parser.enclosedWithCommas(Parsers.scala:601)
	dotty.tools.dotc.parsing.Parsers$Parser.inParensWithCommas(Parsers.scala:614)
	dotty.tools.dotc.parsing.Parsers$Parser.termParamClause(Parsers.scala:3568)
	dotty.tools.dotc.parsing.Parsers$Parser.recur$6(Parsers.scala:3582)
	dotty.tools.dotc.parsing.Parsers$Parser.termParamClauses(Parsers.scala:3590)
	dotty.tools.dotc.parsing.Parsers$Parser.defDefOrDcl(Parsers.scala:3886)
	dotty.tools.dotc.parsing.Parsers$Parser.defOrDcl(Parsers.scala:3772)
	dotty.tools.dotc.parsing.Parsers$Parser.localDef(Parsers.scala:4571)
	dotty.tools.dotc.parsing.Parsers$Parser.blockStatSeq$$anonfun$1(Parsers.scala:4595)
	dotty.tools.dotc.parsing.Parsers$Parser.checkNoEscapingPlaceholders(Parsers.scala:528)
	dotty.tools.dotc.parsing.Parsers$Parser.blockStatSeq(Parsers.scala:4601)
	dotty.tools.dotc.parsing.Parsers$Parser.block(Parsers.scala:2865)
	dotty.tools.dotc.parsing.Parsers$Parser.blockExpr$$anonfun$1(Parsers.scala:2857)
	dotty.tools.dotc.parsing.Parsers$Parser.enclosed(Parsers.scala:592)
	dotty.tools.dotc.parsing.Parsers$Parser.inBraces(Parsers.scala:611)
	dotty.tools.dotc.parsing.Parsers$Parser.inBracesOrIndented(Parsers.scala:625)
	dotty.tools.dotc.parsing.Parsers$Parser.inDefScopeBraces(Parsers.scala:628)
	dotty.tools.dotc.parsing.Parsers$Parser.blockExpr(Parsers.scala:2855)
	dotty.tools.dotc.parsing.Parsers$Parser.simpleExpr(Parsers.scala:2692)
	dotty.tools.dotc.parsing.Parsers$Parser.$init$$$anonfun$9(Parsers.scala:2645)
	dotty.tools.dotc.parsing.Parsers$Parser.postfixExpr(Parsers.scala:2621)
	dotty.tools.dotc.parsing.Parsers$Parser.expr1(Parsers.scala:2463)
	dotty.tools.dotc.parsing.Parsers$Parser.expr(Parsers.scala:2353)
	dotty.tools.dotc.parsing.Parsers$Parser.$init$$$anonfun$8(Parsers.scala:2322)
	dotty.tools.dotc.parsing.Parsers$Parser.subPart(Parsers.scala:692)
	dotty.tools.dotc.parsing.Parsers$Parser.subExpr(Parsers.scala:2324)
	dotty.tools.dotc.parsing.Parsers$Parser.defDefOrDcl(Parsers.scala:3896)
	dotty.tools.dotc.parsing.Parsers$Parser.defOrDcl(Parsers.scala:3772)
	dotty.tools.dotc.parsing.Parsers$Parser.templateStatSeq$$anonfun$1(Parsers.scala:4509)
	dotty.tools.dotc.parsing.Parsers$Parser.checkNoEscapingPlaceholders(Parsers.scala:528)
	dotty.tools.dotc.parsing.Parsers$Parser.templateStatSeq(Parsers.scala:4517)
	dotty.tools.dotc.parsing.Parsers$Parser.$anonfun$39(Parsers.scala:4392)
	dotty.tools.dotc.parsing.Parsers$Parser.enclosed(Parsers.scala:592)
	dotty.tools.dotc.parsing.Parsers$Parser.inBracesOrIndented(Parsers.scala:622)
	dotty.tools.dotc.parsing.Parsers$Parser.inDefScopeBraces(Parsers.scala:628)
	dotty.tools.dotc.parsing.Parsers$Parser.templateBody(Parsers.scala:4392)
	dotty.tools.dotc.parsing.Parsers$Parser.templateBodyOpt(Parsers.scala:4385)
	dotty.tools.dotc.parsing.Parsers$Parser.template(Parsers.scala:4362)
	dotty.tools.dotc.parsing.Parsers$Parser.templateOpt(Parsers.scala:4370)
	dotty.tools.dotc.parsing.Parsers$Parser.classDefRest(Parsers.scala:4031)
	dotty.tools.dotc.parsing.Parsers$Parser.classDef(Parsers.scala:4026)
	dotty.tools.dotc.parsing.Parsers$Parser.tmplDef(Parsers.scala:4000)
	dotty.tools.dotc.parsing.Parsers$Parser.defOrDcl(Parsers.scala:3778)
	dotty.tools.dotc.parsing.Parsers$Parser.topStatSeq(Parsers.scala:4449)
	dotty.tools.dotc.parsing.Parsers$Parser.topstats$1(Parsers.scala:4637)
	dotty.tools.dotc.parsing.Parsers$Parser.topstats$1(Parsers.scala:4631)
	dotty.tools.dotc.parsing.Parsers$Parser.compilationUnit$$anonfun$1(Parsers.scala:4642)
	dotty.tools.dotc.parsing.Parsers$Parser.checkNoEscapingPlaceholders(Parsers.scala:528)
	dotty.tools.dotc.parsing.Parsers$Parser.compilationUnit(Parsers.scala:4647)
	dotty.tools.dotc.parsing.Parsers$Parser.parse(Parsers.scala:201)
	dotty.tools.dotc.parsing.Parser.parse$$anonfun$1(ParserPhase.scala:32)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:15)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:10)
	dotty.tools.dotc.core.Phases$Phase.monitor(Phases.scala:503)
	dotty.tools.dotc.parsing.Parser.parse(ParserPhase.scala:40)
	dotty.tools.dotc.parsing.Parser.$anonfun$2(ParserPhase.scala:52)
	scala.collection.Iterator$$anon$6.hasNext(Iterator.scala:479)
	scala.collection.Iterator$$anon$9.hasNext(Iterator.scala:583)
	scala.collection.immutable.List.prependedAll(List.scala:152)
	scala.collection.immutable.List$.from(List.scala:685)
	scala.collection.immutable.List$.from(List.scala:682)
	scala.collection.IterableOps$WithFilter.map(Iterable.scala:900)
	dotty.tools.dotc.parsing.Parser.runOn(ParserPhase.scala:51)
	dotty.tools.dotc.Run.runPhases$1$$anonfun$1(Run.scala:343)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:15)
	scala.runtime.function.JProcedure1.apply(JProcedure1.java:10)
	scala.collection.ArrayOps$.foreach$extension(ArrayOps.scala:1323)
	dotty.tools.dotc.Run.runPhases$1(Run.scala:336)
	dotty.tools.dotc.Run.compileUnits$$anonfun$1(Run.scala:384)
	dotty.tools.dotc.Run.compileUnits$$anonfun$adapted$1(Run.scala:396)
	dotty.tools.dotc.util.Stats$.maybeMonitored(Stats.scala:69)
	dotty.tools.dotc.Run.compileUnits(Run.scala:396)
	dotty.tools.dotc.Run.compileSources(Run.scala:282)
	dotty.tools.dotc.interactive.InteractiveDriver.run(InteractiveDriver.scala:161)
	dotty.tools.pc.MetalsDriver.run(MetalsDriver.scala:47)
	dotty.tools.pc.SemanticdbTextDocumentProvider.textDocument(SemanticdbTextDocumentProvider.scala:32)
	dotty.tools.pc.ScalaPresentationCompiler.semanticdbTextDocument$$anonfun$1(ScalaPresentationCompiler.scala:246)
```
#### Short summary: 

java.lang.AssertionError: assertion failed