// http://aperiodic.net/phil/scala/s-99/p01.scala

object P01 {
	def last[A](lst: List[A]): A = lst match {
		case h::Nil  => h
		case _::tail => last(tail)
		case _ 		 => throw new NoSuchElementException
	}
}
