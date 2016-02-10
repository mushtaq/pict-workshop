import scala.collection.mutable

1

def map[A, B](xs: List[A])(f: A => B): List[B] = {

  val it = xs.iterator

  var result = List.empty[B]

  while (it.hasNext) {
    result = f(it.next()) :: result
  }

  result.reverse
}

def map2[A, B](xs: List[A])(f: A => B): List[B] = {

  val it = xs.iterator

  val result = mutable.Buffer.empty[B]

  while (it.hasNext) {
    result.append(f(it.next()))
  }

  result.toList
}
def map3[A, B](xs: List[A])(f: A => B): List[B] = {

  val it = xs.iterator

  val result = mutable.Buffer.empty[B]

  while (it.hasNext) {
    result.append(f(it.next()))
  }

  result.toList
}

def square(x: Int) = x * x

val xs = List(1, 2, 3, 4)

map2(xs)(square)
map2(xs)(x => x * x)
map2(xs)(x => x.toString)


