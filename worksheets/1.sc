

val iranS: Int => Boolean = { age: Int =>
  age > 100
}

class USS extends Function1[Int, Boolean] {
  def apply(age: Int): Boolean = age > 20
}



canDrink(110)

class Person(age: Int, isFemale: Boolean) {
  def isWise: Boolean = if (isFemale) age > 10 else age > 15

  def canMarry(canDrink: Int => Boolean) =
    isWise & canDrink(age)
}


val p = new Person(25, true)

def canDrink(age: Int) = age > 100
p.canMarry(canDrink)

p.canMarry(new USS)
p.canMarry(iranS)
p.canMarry { age: Int =>
  age > 100
}
p.canMarry(age => age > 100)

p.canMarry(_ > 100)
p.canMarry(new Function1[Int, Boolean] {
  def apply(age: Int): Boolean = age > 40
})




