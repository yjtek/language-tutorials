package objsets

import TweetReader.*

/**
 * A class to represent tweets.
 */
class Tweet(val user: String, val text: String, val retweets: Int):
  override def toString: String =
    "User: " + user + "\n" +
    "Text: " + text + " [" + retweets + "]"

/**
 * This represents a set of objects of type `Tweet` in the form of a binary search
 * tree. Every branch in the tree has two children (two `TweetSet`s). There is an
 * invariant which always holds: for every branch `b`, all elements in the left
 * subtree are smaller than the tweet at `b`. The elements in the right subtree are
 * larger.
 *
 * Note that the above structure requires us to be able to compare two tweets (we
 * need to be able to say which of two tweets is larger, or if they are equal). In
 * this implementation, the equality / order of tweets is based on the tweet's text
 * (see `def incl`). Hence, a `TweetSet` could not contain two tweets with the same
 * text from different users.
 *
 *
 * The advantage of representing sets as binary search trees is that the elements
 * of the set can be found quickly. If you want to learn more you can take a look
 * at the Wikipedia page [1], but this is not necessary in order to solve this
 * assignment.
 *
 * [1] http://en.wikipedia.org/wiki/Binary_search_tree
 */
abstract class TweetSet extends TweetSetInterface:

  /**
   * This method takes a predicate and returns a subset of all the elements
   * in the original set for which the predicate is true.
   *
   * Question: Can we implement this method here, or should it remain abstract
   * and be implemented in the subclasses?
   */
  def filter(p: Tweet => Boolean): TweetSet = {
    filterAcc(p, new Empty)
    // val acc = new Empty
    // filterAcc(p, acc)
    // filterAcc(p, Empty())
  }

  /**
   * This is a helper method for `filter` that propagates the accumulated tweets.
   */
  def filterAcc(p: Tweet => Boolean, acc: TweetSet): TweetSet

  /**
   * Returns a new `TweetSet` that is the union of `TweetSet`s `this` and `that`.
   *
   * Question: Should we implement this method here, or should it remain abstract
   * and be implemented in the subclasses?
   */
  def union(that: TweetSet): TweetSet = ???

  /**
   * Returns the tweet from this set which has the greatest retweet count.
   *
   * Calling `mostRetweeted` on an empty set should throw an exception of
   * type `java.util.NoSuchElementException`.
   *
   * Question: Should we implement this method here, or should it remain abstract
   * and be implemented in the subclasses?
   */
  def mostRetweeted: Tweet = ???

  /**
   * Returns a list containing all tweets of this set, sorted by retweet count
   * in descending order. In other words, the head of the resulting list should
   * have the highest retweet count.
   *
   * Hint: the method `remove` on TweetSet will be very useful.
   * Question: Should we implement this method here, or should it remain abstract
   * and be implemented in the subclasses?
   */
  def descendingByRetweet: TweetList = ???

  /**
   * The following methods are already implemented
   */

  /**
   * Returns a new `TweetSet` which contains all elements of this set, and the
   * the new element `tweet` in case it does not already exist in this set.
   *
   * If `this.contains(tweet)`, the current set is returned.
   */
  def incl(tweet: Tweet): TweetSet

  /**
   * Returns a new `TweetSet` which excludes `tweet`.
   */
  def remove(tweet: Tweet): TweetSet

  /**
   * Tests if `tweet` exists in this `TweetSet`.
   */
  def contains(tweet: Tweet): Boolean

  /**
   * This method takes a function and applies it to every element in the set.
   */
  def foreach(f: Tweet => Unit): Unit

class Empty extends TweetSet:
  def filterAcc(p: Tweet => Boolean, acc: TweetSet): TweetSet = {
    acc
  }

  override def union(that: TweetSet): TweetSet = {
    that
  }

  override def mostRetweeted: Tweet = {
    throw new NoSuchElementException("Empty TweetSet")
  }

  override def descendingByRetweet: TweetList = {
    Nil
  }

  /**
   * The following methods are already implemented
   */

  def contains(tweet: Tweet): Boolean = false

  def incl(tweet: Tweet): TweetSet = NonEmpty(tweet, Empty(), Empty())

  def remove(tweet: Tweet): TweetSet = this

  def foreach(f: Tweet => Unit): Unit = ()

class NonEmpty(elem: Tweet, left: TweetSet, right: TweetSet) extends TweetSet:

  // def filterAcc(p: Tweet => Boolean, acc: TweetSet): TweetSet = {
  //   val updatedAcc = if p(elem) then acc.incl(elem) else acc
  //   left.filterAcc(p, updatedAcc).union(right.filterAcc(p, updatedAcc))
  // }

  // override def filterAcc(p: Tweet => Boolean, acc: TweetSet): TweetSet = {
  //   val newAcc = if (p(elem)) acc.incl(elem) else acc
  //   right.filterAcc(p, left.filterAcc(p, newAcc))
  // }

  def filterAcc(p: Tweet => Boolean, acc: TweetSet): TweetSet = {
    if (p(elem)) then right.filterAcc(p, left.filterAcc(p, acc.incl(elem)))
    else right.filterAcc(p, left.filterAcc(p, acc))
  }

  override def union(that: TweetSet): TweetSet = {
    // left.union(right).union(that).incl(elem)
    left.union(right.union(that.incl(elem)))
  }

  override def mostRetweeted: Tweet = {
    filter(p => p.retweets > elem.retweets) match {
      case ne: NonEmpty => ne.mostRetweeted
      case e: Empty => elem
    }

    // val leftMax = if (left.isInstanceOf[Empty]) elem else left.mostRetweeted
    // val rightMax = if (right.isInstanceOf[Empty]) elem else right.mostRetweeted
    
    // if (elem.retweets >= leftMax.retweets && elem.retweets >= rightMax.retweets) elem
    // else if (leftMax.retweets >= rightMax.retweets) leftMax
    // else rightMax

    // def getHigherRetweet(t1: Tweet, t2: Tweet): Tweet = {
    //   if t1.retweets > t2.retweets then t1 else t2
    // }
    
    // var leftMostRetweeted = if (!left.isInstanceOf[Empty]) left.mostRetweeted else elem
    // var rightMostRetweeted = if (!right.isInstanceOf[Empty]) right.mostRetweeted else elem

    // getHigherRetweet(elem, getHigherRetweet(leftMostRetweeted, rightMostRetweeted))
  }

  override def descendingByRetweet: TweetList = {
    val max = mostRetweeted
    new Cons(max, remove(max).descendingByRetweet)

    // new Cons(this.mostRetweeted, remove(this.mostRetweeted).descendingByRetweet)
  }

  /**
   * The following methods are already implemented
   */

  def contains(x: Tweet): Boolean =
    if x.text < elem.text then
      left.contains(x)
    else if elem.text < x.text then
      right.contains(x)
    else true

  def incl(x: Tweet): TweetSet =
    if x.text < elem.text then
      NonEmpty(elem, left.incl(x), right)
    else if elem.text < x.text then
      NonEmpty(elem, left, right.incl(x))
    else
      this

  def remove(tw: Tweet): TweetSet =
    if tw.text < elem.text then
      NonEmpty(elem, left.remove(tw), right)
    else if elem.text < tw.text then
      NonEmpty(elem, left, right.remove(tw))
    else
      left.union(right)

  def foreach(f: Tweet => Unit): Unit =
    f(elem)
    left.foreach(f)
    right.foreach(f)

trait TweetList:
  def head: Tweet
  def tail: TweetList
  def isEmpty: Boolean
  def foreach(f: Tweet => Unit): Unit =
    if !isEmpty then
      f(head)
      tail.foreach(f)

object Nil extends TweetList:
  def head = throw java.util.NoSuchElementException("head of EmptyList")
  def tail = throw java.util.NoSuchElementException("tail of EmptyList")
  def isEmpty = true

class Cons(val head: Tweet, val tail: TweetList) extends TweetList:
  def isEmpty = false


object GoogleVsApple:
  val google = List("android", "Android", "galaxy", "Galaxy", "nexus", "Nexus")
  val apple = List("ios", "iOS", "iphone", "iPhone", "ipad", "iPad")

  lazy val googleTweets: TweetSet = TweetReader.allTweets.filter(tweet => google.exists(text => tweet.text.contains(text)))
  lazy val appleTweets: TweetSet = TweetReader.allTweets.filter(tweet => apple.exists(text => tweet.text.contains(text)))

  /**
   * A list of all tweets mentioning a keyword from either apple or google,
   * sorted by the number of retweets.
   */
  lazy val trending: TweetList = googleTweets.union(appleTweets).descendingByRetweet

object Main extends App:
  // Print the trending tweets
  GoogleVsApple.trending foreach println
