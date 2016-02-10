
List(1, 2, 2, 3).map(x => x * x)

Set(1, 2, 2, 3).map(x => x * x)

Map( 1 -> "a", 2 -> "b").map(t => (t._1, s"Hello ${t._2}"))
Map( 1 -> "a", 2 -> "a").map(t => (t._2, t._1))
Map( 1 -> "a", 2 -> "b").mapValues(v => s"Hello $v")

(1, "a")
(1, "a", 100)



val xs: List[Int] = List(1, 2, 2, 3, 20, 100, 44)
val xs2: List[Int] = List(1, 2)
val xs1: Int => Int = List(1, 2, 2, 3)


val ys: Set[Int] = Set(1, 2, 2, 3)
val ys1: Int => Boolean = Set(1, 2, 2, 3)

xs.filter(x => ys.contains(x))
xs.filter(x => ys.apply(x))
xs.filter(ys.apply)
xs.filter(ys)



val zs: Map[Int, String] = Map( 1 -> "a", 2 -> "b")
val zs1: Int => String = Map( 1 -> "a", 2 -> "b")

xs2.map(zs)


xs.apply(3)
ys(100)
ys.apply(1)

zs(1)
zs(2)

