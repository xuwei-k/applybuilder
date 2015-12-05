package scalaz

import ApplyBuilder._
import std.AllInstances._
import syntax.validation._
import syntax.equal._

object ApplyBuilderExample {

  def main(args: Array[String]) {
    def a(n: Int): ValidationNel[Int, Long] = n.failureNel[Long]

    type T22[A] = Tuple22[A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A, A]

    val b: ValidationNel[Int, T22[Long]] =
      %%%%%%%%%%%%%%%%%%%%%(
        a(1) , a(2) , a(3) , a(4) , a(5) , a(6) , a(7) , a(8) , a(9) , a(10),
        a(11), a(12), a(13), a(14), a(15), a(16), a(17), a(18), a(19), a(20),
        a(21), a(22)
      ).tupled

    println(b)

    (b: @unchecked) match {
      case Failure(errors) => errors assert_=== NonEmptyList(1, 2 to 22 :_*)
    }
  }

}

