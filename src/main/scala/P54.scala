/*
  P54 Omitted; our tree representation will only allow well-formed trees.
  Score one for static typing.
*/

sealed abstract class Tree[+T]

case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T]

case object Empty extends Tree[Nothing]

object Node {
  def apply[T](value: T): Node[T] = Node(value, Empty, Empty)
}
