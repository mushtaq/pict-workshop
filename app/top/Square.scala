package top

import top.utils.{BlockingConfig, Scheduler}

import scala.concurrent.Future
import scala.concurrent.duration.DurationInt
import scala.util.Random

object Square {

  def delay: Int = Random.nextInt(1000)

  def square(a: Int): Int = a * a

  def blocking(a: Int): Int = {
    println(s"begin squaring $a")

    Thread.sleep(delay)

    val result = square(a)

    println(s"END SQUARING $a")

    result
  }

  def async(a: Int): Future[Int] = Future {

    blocking(a)
  }(BlockingConfig.executionContext)

  def nonBlocking(a: Int): Future[Int] = {
    println(s"begin (non-blocking) squaring $a")

    Scheduler.asFuture(delay.millis) {

      val result = square(a)

      println(s"END (NON_BLOCKING) SQUARING $a")

      result
    }
  }
}
