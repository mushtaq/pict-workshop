

def foldLeft[A, B](xs: List[A])(seed: B)(f: (B, A) => B): B = {
  if(xs.isEmpty) {
    seed
  } else {
    foldLeft(xs.tail)(f(seed, xs.head))(f)
  }
}

foldLeft(List(1, 2, 3, 4))(1)(_ * _)
foldLeft(List(1, 2, 3, 4))(1)((acc, elm) => acc * elm)
foldLeft(List(1, 2, 3, 4))("")(_ + _)



