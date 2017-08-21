/*
  P13 (**) Run-length encoding of a list (direct solution).
  Implement the so-called run-length encoding data compression method directly. I.e. don't use other methods you've written (like P09's pack); do all the work directly.
  Example:

  scala> encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))

  http://aperiodic.net/phil/scala/s-99/p13.scala
 */
 
object P13 {
  def encodeDirect[A](lst: List[A]): List[(Int, A)] = {
    if (lst.isEmpty)
      Nil
    else {
      val (packed, next) = lst span { _ == lst.head }
      (packed.length, packed.head) :: encodeDirect(next)
    }
  }	
}
