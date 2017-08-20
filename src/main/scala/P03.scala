/*
  P03 (*) Find the Kth element of a list.
  By convention, the first element in the list is element 0.
  Example:

  scala> nth(2, List(1, 1, 2, 3, 5, 8))
  res0: Int = 2
  
  http://aperiodic.net/phil/scala/s-99/p03.scala
*/

object P03 {
  def nth[A](n: Int, lst: List[A]): A = (n, lst) match {
    case (0, h :: _)    => h
    case (n, _ :: tail) => nth(n - 1, tail)
    case (_, Nil)       => throw new NoSuchElementException
  }
}
