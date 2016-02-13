package top

import akka.actor.{ActorRef, Actor}
import akka.actor.Actor.Receive
import top.CounterActor.{Count, Delay, Next}
import top.utils.Scheduler

import scala.concurrent.duration.DurationInt

class Counter {

  private var currentId = 0

  def next() = synchronized {
    Thread.sleep(100)
    currentId += 1
    currentId
  }

}

class CounterActor extends Actor {

  var currentId = 0

  import context.dispatcher

  def receive: Receive = {
    case Next =>
      context.system.scheduler.scheduleOnce(100.millis, self, Delay(sender()))
    case Delay(replyTo) =>
      currentId += 1
      replyTo ! Count(currentId)
  }
}

object CounterActor {
  case object Next
  case class Delay(replyTo: ActorRef)
  case class Count(n: Int)
}