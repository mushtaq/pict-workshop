package top.utils

import java.util.concurrent.{ScheduledExecutorService, Executors}
import akka.actor.ActorSystem
import akka.stream.ActorMaterializer

import scala.concurrent.{ExecutionContextExecutorService, ExecutionContext}

object Config extends Config(numberOfThreads = 4)

object BlockingConfig extends Config(numberOfThreads = 40)

class Config(numberOfThreads: Int) {

  val threadPool: ScheduledExecutorService =
    Executors.newScheduledThreadPool(numberOfThreads)

  implicit val executionContext: ExecutionContextExecutorService =
    ExecutionContext.fromExecutorService(threadPool)

  implicit val system = ActorSystem("Sony")

  implicit val mat = ActorMaterializer()
}
