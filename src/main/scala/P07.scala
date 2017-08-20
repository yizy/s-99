/*
  P07 (**) Flatten a nested list structure.
  Example:
  scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
  res0: List[Any] = List(1, 1, 2, 3, 5, 8)
	
  http://aperiodic.net/phil/scala/s-99/p07.scala
*/

object P07 {
  def flattenSimple(lst: List[Any]): List[Any] = lst match {
    case (l: List[_]) :: tail => flattenSimple(l) ::: flattenSimple(tail)
    case h :: tail   	  			=> h :: flattenSimple(tail)
    case Nil 									=> Nil
  }

  def flattenByFlatMap(lst: List[Any]): List[Any] = lst.flatMap {
    case l: List[_] => flattenByFlatMap(l)
    case e 					=> List(e)
  }
}
