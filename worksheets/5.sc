

def reverse[T](xs: List[T]): List[T] = {
  if(xs.isEmpty) {
    xs
  } else {
    reverse(xs.tail) ::: List(xs.head)
  }
}

def reverse2[T](xs: List[T]): List[T] = {
  def loop(xs: List[T], result: List[T]): List[T] = {
    if(xs.isEmpty) {
      result
    } else {
      loop(xs.tail, xs.head :: result)
    }
  }

  loop(xs, List.empty)
}

def reverse3[T](xs: List[T]): List[T] =
  xs.foldLeft(List.empty[T])((acc, elm) => elm :: acc)

reverse(List(1, 2, 3, 4))
reverse2(List(1, 2, 3, 4))
reverse3(List(1, 2, 3, 4))




