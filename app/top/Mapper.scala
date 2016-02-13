package top

import scala.concurrent.{Promise, Future}
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global

object Mapper extends App {

  def map[A, B](future: Future[A])(f: A => B): Future[B] = {

    val promise = Promise[B]()

    future.onComplete {
      case Success(x)  => promise.success(f(x))
      case Failure(ex) => promise.failure(ex)
    }

    promise.future

  }

  map(Future(9/0))(x => x * x ).onComplete(println)

  Thread.sleep(1000)

}
