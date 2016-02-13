
//def divide10By(n: Int) = 10 / n
//


val divide10By: Function1[Int, Int] = {
  case 0 => 0
  case n => 10 / n
}

divide10By(1)
divide10By(0)
divide10By(2)

val pf: PartialFunction[Int, Int] = {
  case n if n != 0 => 10 / n
}

pf(1)
pf(2)

pf.isDefinedAt(0)
pf.isDefinedAt(100)
