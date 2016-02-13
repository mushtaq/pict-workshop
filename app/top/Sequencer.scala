package top

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Future, Promise}
import scala.util.{Failure, Success}
import scala.async.Async._

object Sequencer extends App {

  def sequence()

  Thread.sleep(1000)

}
