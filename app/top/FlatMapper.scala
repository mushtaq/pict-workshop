package top

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.async.Async._

object FlatMapper extends App {

  val f1 = Future.successful(10)
  val f2 = Future.successful(20)

  val result = f1.flatMap { x =>
    f2.map { y =>
      x + y
    }
  }

  val result2 = for {
    x <- f1
    y <- f2
  } yield x + y

  val result3 = async {
    val x = await(f1)
    val y = await(f2)
    x + y
  }


  result.onComplete(println)
  result2.onComplete(println)
  result3.onComplete(println)

  Thread.sleep(1000)

}
