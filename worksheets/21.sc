import data.{Book, Data}
import top.{Ord, Sorter}

Sorter.sort(List(2, 3, 1, 4, 2, 7))

Sorter.sort(List("b", "x", "s", "a", "f"))

{
  implicit val intOrd: Ord[Int] = new Ord[Int] {
    def lt(a: Int, b: Int): Boolean = a > b
  }


  Sorter.sort(List(Option(2), None, Option(1)))
}

Sorter.sort(List(Option("b"), None, Option("a")))

Sorter.sort(List((2, "b"), (2, "a"), (1, "z")))
Sorter.sort(List((Option(2), Option("b")), (Option(2), None), (Option(1), Option("z"))))


Sorter.sort(List(Option(Data.books(3)), None, Option(Data.books(1))))

