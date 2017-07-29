import org.scalatest.FunSuite

class P01Suite extends FunSuite {
	test("list len is equal to 0") {
		val lst = List()
		intercept[NoSuchElementException] {P01.last[Int](lst)}
	}

	test("list len is equal to 1") {
		val lst = List(1)
		assert(P01.last[Int](lst) == 1)
	}

	test("list len is equal to 2") {
		val lst = List(1, 2)
		assert(P01.last[Int](lst) == 2)
	}

	test("list len is equal to 3") {
		val lst = List(1, 2, 3)
		assert(P01.last[Int](lst) == 3)
	}
}