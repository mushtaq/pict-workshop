

val xs = List(10, 2, 3)

xs.map(x => x * x)

xs.filter(x => x > 2)
xs.filterNot(x => x > 2)
xs.partition(x => x > 2)

xs.takeWhile(x => x > 1)
xs.dropWhile(x => x > 1)
xs.span(x => x > 1)

xs.take(2)
xs.drop(2)
xs.splitAt(2)

xs.reduceLeft((acc, elm) => acc * elm)
xs.reduceLeft((acc, elm) => acc + elm)

xs.foldLeft(0)((acc, elm) => acc + elm)
xs.foldLeft(1)((acc, elm) => acc * elm)

xs.foldLeft("")((acc, elm) => acc + elm)




