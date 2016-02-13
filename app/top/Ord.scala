package top

trait Ord[T] {
  def lt(a: T, b: T): Boolean
}

object Ord {

  implicit val intOrd: Ord[Int] = new Ord[Int] {
    def lt(a: Int, b: Int): Boolean = a < b
  }

  implicit val strOrd: Ord[String] = new Ord[String] {
    def lt(a: String, b: String): Boolean = a < b
  }

  implicit def tupleOrd[T1, T2](implicit ord1: Ord[T1], ord2: Ord[T2]): Ord[(T1, T2)] = new Ord[(T1, T2)] {
    def lt(a: (T1, T2), b: (T1, T2)): Boolean = {
      if(ord1.lt(a._1, b._1)) true
      else if(ord1.lt(b._1, a._1)) false
      else ord2.lt(a._2, b._2)
    }
  }


  implicit def optOrd[T](implicit ord: Ord[T]): Ord[Option[T]] = new Ord[Option[T]] {
    def lt(a: Option[T], b: Option[T]): Boolean = (a, b) match {
      case (Some(x), Some(y)) => ord.lt(x, y)
      case (None, _)          => true
      case (_, None)          => false
    }
  }

}
