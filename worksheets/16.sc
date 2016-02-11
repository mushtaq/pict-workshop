
sealed trait Json

case object JsNull extends Json

case class JsBoolean(value: Boolean) extends Json
case class JsString(value: String) extends Json
case class JsNumber(value: Double) extends Json

case class JsArray(value: List[Json]) extends Json
case class JsObject(value: Map[String, Json]) extends Json


