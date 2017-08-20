/*
  P05 (*) Reverse a list.
  Example:
  scala> reverse(List(1, 1, 2, 3, 5, 8))
  res0: List[Int] = List(8, 5, 3, 2, 1, 1)
  
  http://aperiodic.net/phil/scala/s-99/p05.scala
*/

import scala.annotation.tailrec

object P05 {
  def reverseSimple[A](lst: List[A]): List[A] = lst match {
    case h :: tail => reverseSimple(tail) ::: List(h)
    case Nil       => Nil
  }

  @tailrec
  def reverseTailRec[A](lst: List[A], res: List[A] = Nil): List[A] = lst match {
    case h :: tail => reverseTailRec(tail, h :: res)
    case Nil       => res
  }
  
  def reverseByFold[A](lst: List[A]): List[A] = lst.foldLeft(List[A]()) { (b, a) => a :: b}
}
