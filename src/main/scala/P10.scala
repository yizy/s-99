/*
  P10 (*) Run-length encoding of a list.
  Use the result of problem P09 to implement the so-called run-length encoding data compression method. Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates of the element E.
  Example:

  scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))

  http://aperiodic.net/phil/scala/s-99/p10.scala
 */

import scala.annotation.tailrec

object P10 {
  @tailrec
  def encode(lst: List[Any], tmp: List[Any] = Nil, res: List[(Int, Any)] = Nil): List[(Int, Any)] = lst match {
    case h :: tail if tmp.isEmpty || tmp.head == h => encode(tail, h :: tmp, res)
    case h :: tail                                 => encode(tail, List(h), (tmp.size, tmp.head) :: res)
    case Nil                                       => ((tmp.size, tmp.head) :: res).reverse
  }
}
