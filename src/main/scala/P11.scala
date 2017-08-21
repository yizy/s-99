/*
  P11 (*) Modified run-length encoding.
  Modify the result of problem P10 in such a way that if an element has no duplicates it is simply copied into the result list. Only elements with duplicates are transferred as (N, E) terms.
  Example:

  scala> encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))

  http://aperiodic.net/phil/scala/s-99/p11.scala
 */

import scala.annotation.tailrec

object P11 {
  @tailrec
  def encodeModified(lst: List[Any], tmp: List[Any] = Nil, res: List[Any] = Nil): List[Any] = lst match {
    case h :: tail if tmp.isEmpty || tmp.head == h => encodeModified(tail, h :: tmp, res)
    case h :: tail =>
      val head = if (tmp.size == 1) tmp.head else (tmp.size, tmp.head)
      encodeModified(tail, List(h),  head :: res)
    case Nil => 
      val head = if (tmp.size == 1) tmp.head else (tmp.size, tmp.head)
      (head :: res).reverse
  }
}
