import scala.concurrent.Future

val xs = List(1, 2, 3)

val ys = List("a", "b", "c")

xs.map(x => ys.map(y => (x, y))).flatten

xs.flatMap(x => ys.map(y => (x, y)))

for {
  x <- xs
  if x > 2
  y <- ys
  if y == "c"
} yield (x, y)

Future.failed(new RuntimeException("asdasd"))
