/*
  P06 (*) Find out whether a list is a palindrome.
  Example:
  scala> isPalindrome(List(1, 2, 3, 2, 1))
  res0: Boolean = true
	
  http://aperiodic.net/phil/scala/s-99/p06.scala
*/

object P06 {
	def isPalindrome[A](lst: List[A]): Boolean = lst == lst.reverse
}
