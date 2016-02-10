import scala.annotation.tailrec

def map6[A, B](xs: List[A])(f: A => B): List[B] = {
  xs.foldLeft(List.empty[B])((acc, elm) => f(elm) :: acc).reverse
}

def map5[A, B](xs: List[A])(f: A => B): List[B] = {

  @tailrec
  def loop(remaining: List[A], result: List[B]): List[B] = {
    if(remaining.isEmpty) {
      result
    } else {
      loop(remaining.tail, f(remaining.head) :: result)
    }
  }

  loop(xs, List.empty[B]).reverse

}

def map4[A, B](xs: List[A])(f: A => B): List[B] = {
  if(xs.isEmpty) {
    List.empty[B]
  } else {
    f(xs.head) :: map4(xs.tail)(f)
  }
}

def square(x: Int) = x * x

val xs = (1 to 10000).toList

map5(xs)(square)

