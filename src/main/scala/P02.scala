/*
  P02 (*) Find the last but one element of a list.
  Example:
  scala> penultimate(List(1, 1, 2, 3, 5, 8))
  res0: Int = 5
  
  http://aperiodic.net/phil/scala/s-99/p02.scala
*/

object P02 {
  def penultimate[A](lst: List[A]): A = lst match {
    case h :: _ :: Nil => h
    case _ :: tail     => penultimate(tail)
    case _             => throw new NoSuchElementException
  }
}
