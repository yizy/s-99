/*
  P08 (**) Eliminate consecutive duplicates of list elements.
  If a list contains repeated elements they should be replaced with a single copy of the element. The order of the elements should not be changed.
  Example:

  scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)
  
  http://aperiodic.net/phil/scala/s-99/p08.scala
*/

import scala.annotation.tailrec

object P08 {
  @tailrec
  def compressTailRec[A](lst: List[A], res: List[A] = Nil): List[A] = lst match {
    case h :: tail => compressTailRec(tail.dropWhile(_ == h), h :: res)
    case Nil 		   => res.reverse
  }

  def compressFunctional[A](lst: List[A]): List[A] = lst.foldRight(List[A]()) { case (h, res) =>
    if (res.isEmpty || res.head != h) h :: res else res
  }
}
