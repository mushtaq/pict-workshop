package top

import org.specs2.mutable.Specification
import play.api.libs.ws.WS
import play.api.test.WithApplication
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class Squares extends Specification {

  "squares" in new WithApplication() {

    (1 to 100).foreach { n =>
      WS.url(s"http://localhost:9000/square/$n").get().foreach(x => println(x.json))
    }


    Thread.sleep(10000)
  }



}
