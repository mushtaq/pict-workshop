
class A {
  def m = 10
}

object A {
  def m = 10
}


A: A.type

val a: A = new A

a.m
A.m


val a1: A = new A

val x: a.type  = a
val x1: a1.type  = a1



