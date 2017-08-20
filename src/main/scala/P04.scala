/*
  P04 (*) Find the number of elements of a list.
  Example:
  scala> length(List(1, 1, 2, 3, 5, 8))
  res0: Int = 6
  
  http://aperiodic.net/phil/scala/s-99/p04.scala
*/

import scala.annotation.tailrec

object P04 {
  def lengthSimple[A](lst: List[A]): Int = lst match {
    case _ :: tail => 1 + lengthSimple(tail)
    case Nil       => 0
	}

	@tailrec
	def lengthTailRec[A](lst: List[A], n: Int = 0): Int = lst match {
    case _ :: tail => lengthTailRec(tail, n + 1)
    case Nil       => n
	}

	def lengthByFold[A](lst: List[A]): Int = lst.foldLeft(0) { (b, _) => b + 1}
}
