package controllers

import javax.inject.Inject

import play.api.libs.json.Json
import play.api.mvc._
import top.Square

import scala.concurrent.ExecutionContext

class Application @Inject()(implicit ec: ExecutionContext) extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def square(n: Int) = Action.async {
    Square.nonBlocking(n).map(x => Ok(Json.obj("result" -> x)))
  }

}
