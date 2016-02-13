
sealed trait List[+T]

case object Nil extends List[Nothing]

case class ::[T](head: T, tail: List[T]) extends List[T]

def length[T](xs: List[T]): Int = xs match {
  case Nil            => 0
  case head :: tail => 1 + length(tail)
}

val xs = ::(1, ::(2, ::(3, Nil)))


length(xs)


def reverse[T](xs: List[T]): List[T] = {
  def loop(xs: List[T], result: List[T]): List[T] = xs match {
    case Nil              => result
    case ::(head, tail) => loop(tail, ::(head, result))
  }

  loop(xs, Nil)
}

reverse(xs)