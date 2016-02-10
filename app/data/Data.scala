package data

case class Book(
  author: String,
  title: String,
  basePrice: Double,
  isImported: Boolean
  )

object Data {

  //find top 2 authors by max of total book prices by those authors
  //(minsky, 1088), (odersky, 600)

  val books = List(
    Book("odersky", "scala prog", 100, false),
    Book("odersky", "apple", 100, false),
    Book("odersky", "complexity", 400, false),
    Book("misky", "ocaml prog", 1000, true),
    Book("hickey", "clojure prog", 500, true)
  )

}
