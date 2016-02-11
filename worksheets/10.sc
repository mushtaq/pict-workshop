case class Address(street: String, pin: Int)

object Address

case class Person(name: String, age: Int, address: Address)

val p1 = Person("abc", 33, Address("a", 1))
val p2 = Person("abc", 33, Address("b", 2))

p1 == p2


p1.hashCode()
p2.hashCode()

p1.copy(name = "aaa")

p1.copy(name = "aaa") == p1



