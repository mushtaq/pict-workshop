import data.{Book, Data}

Data.books.filter(_.author == "odersky").map(_.basePrice)

Data.books.collect {
  case Book("odersky" | "misky", _, p, _) => p
}


val pf: PartialFunction[Book, Double] = {
  case Book("odersky" | "misky", _, p, _) => p
}

pf.isDefinedAt(Data.books(3))

Data.books.collect(pf)

Data.books.filter(pf.isDefinedAt).map(pf)

1 :: 2 :: 3 :: Nil

1 :: Nil
