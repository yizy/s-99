/*
  P55 (**) Construct completely balanced binary trees.
  In a completely balanced binary tree, the following property holds for every node: The number of nodes in its left subtree and the number of nodes in its right subtree are almost equal, which means their difference is not greater than one.
  Define an object named Tree. Write a function Tree.cBalanced to construct completely balanced binary trees for a given number of nodes. The function should generate all solutions. The function should take as parameters the number of nodes and a single value to put in all of them.

  scala> Tree.cBalanced(4, "x")
  res0: List(Node[String]) = List(T(x T(x . .) T(x . T(x . .))), T(x T(x . .) T(x T(x . .) .)), ...

	http://aperiodic.net/phil/scala/s-99/p55.scala
 */

sealed abstract class Tree[+T]

case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T]

case object Empty extends Tree[Nothing]

object Node {
  def apply[T](value: T): Tree[T] = Node(value, Empty, Empty)
}

object Tree {
  def cBalanced[T](n: Int, value: T): List[Tree[T]] = {
    if (n < 1) {
      List(Empty)
    } else if (n % 2 == 1) {
      val subtrees = cBalanced(n / 2, value)

      for {
        left <- subtrees
        right <- subtrees
      } yield Node(value, left, right)

    } else {
      val lstOfLst =
        for {
          lesser <- cBalanced((n - 1) / 2, value)
          greater <- cBalanced((n - 1) / 2 + 1, value)
        } yield List(Node(value, lesser, greater), Node(value, greater, lesser))

      lstOfLst.flatMap(identity)
    }
  }
}
