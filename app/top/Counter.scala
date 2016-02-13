package top

class Counter {

  private var currentId = 0

  def next() = synchronized {
    Thread.sleep(100)
    currentId += 1
    currentId
  }

}
