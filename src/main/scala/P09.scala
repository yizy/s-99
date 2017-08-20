/*
  P09 (**) Pack consecutive duplicates of list elements into sublists.
  If a list contains repeated elements they should be placed in separate sublists.
  Example:

  scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
	
  http://aperiodic.net/phil/scala/s-99/p09.scala
 */

import scala.annotation.tailrec

object P09 {
  @tailrec
  def pack(lst: List[Any], tmp: List[Any] = Nil, res: List[Any] = Nil): List[Any] = lst match {
    case h :: tail if tmp.isEmpty || tmp.head == h => pack(tail, h :: tmp, res)
    case h :: tail                                 => pack(tail, List(h), tmp :: res)
    case Nil                                       => (tmp :: res).reverse
  }
}
