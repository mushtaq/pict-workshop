package top

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Future, Promise}
import scala.util.{Failure, Success}
import scala.async.Async._

object Sequencer extends App {


  def sequence[T](futures: List[Future[T]]): Future[List[T]] = {
    val seed = Future.successful(List.empty[T])
    val dd = futures.foldLeft(seed) { (result, future) =>
      for {
        xs <- result
        x <- future
      } yield x :: xs
    }
    dd.map(_.reverse)
  }

  def sequence1[T](futures: List[Future[T]]): Future[List[T]] = {
    val seed = Future.successful(List.empty[T])
    val dd = futures.foldLeft(seed) { (result, future) =>
      for {
        xs <- result
        x <- future
      } yield x :: xs
    }
    dd.map(_.reverse)
  }

  def sequence2[T](futures: List[Future[T]]): Future[List[T]] = async {
    val it = futures.iterator
    var result = List.empty[T]
    while (it.hasNext) {
      result = await(it.next()) :: result
    }
    result.reverse
  }

  sequence(List(Future(1), Future(2), Future(3))).onComplete(println)

  Thread.sleep(1000)

}
