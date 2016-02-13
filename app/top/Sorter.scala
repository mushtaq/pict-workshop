package top

object Sorter {
  def sort[T](xs: List[T])(implicit ord: Ord[T]): List[T] = xs match {
    case Nil => Nil
    case head :: tail => isort(head, sort(tail))
  }

  def isort[T](x: T, xs: List[T])(implicit ord: Ord[T]): List[T] = xs match {
    case Nil                             => x :: Nil
    case head :: tail if ord.lt(x, head) => x :: xs
    case head :: tail                    => head :: isort(x, tail)
  }
}
