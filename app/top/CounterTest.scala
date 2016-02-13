package top

object CounterTest extends App {

  val counter = new Counter

  def thread(id: Int) = new Thread {
    override def run(): Unit = {
      (1 to 100).foreach { x =>
        println(s"thread: $id, nextId: ${counter.next()}")
      }
    }
  }

  (1 to 10).foreach(x => thread(x).start())


}
