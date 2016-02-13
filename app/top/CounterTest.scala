package top

import akka.actor.{Props, ActorSystem}
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.Source
import akka.util.Timeout
import top.CounterActor.{Count, Next}
import akka.pattern.ask

import scala.concurrent.duration._

object CounterTest extends App {

  val counter = new Counter

  def thread(id: Int) = new Thread {
    override def run(): Unit = {
      (1 to 100).foreach { x =>
        println(s"thread: $id, nextId: ${counter.next()}")
      }
    }
  }

//  (1 to 10).foreach(x => thread(x).start())

  implicit val system = ActorSystem("pict")
  implicit val mat = ActorMaterializer()
  import system.dispatcher
  implicit val timeout = Timeout(1.seconds)

  private val counterActor = system.actorOf(Props(new CounterActor))

  def future = (counterActor ? Next).mapTo[Count]

  val stream1 = Source.tick(10.milli, 10.milli, ()).mapAsync(10)(x => future)
  val stream2 = Source.tick(100.milli, 100.milli, ()).mapAsync(10)(x => future)
  val stream3 = Source.tick(50.milli, 50.milli, ()).mapAsync(10)(x => future)

  stream1.runForeach(x => println(s"stream1 value: $x"))
  stream2.runForeach(x => println(s"stream2 value: $x"))
  stream3.runForeach(x => println(s"stream3 value: $x"))

  Thread.sleep(10000)

}
