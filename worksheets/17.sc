import play.api.libs.json._

def transform(jsValue: JsValue): JsValue = jsValue match {
  case JsNull => JsString("null")

  case JsBoolean(value)  => JsBoolean(!value)
  case JsNumber(value)   => JsNumber(value * value)
  case JsString("hello") => JsString("ha ha")

  case JsArray(values) => JsArray(values.map(transform))
  case JsObject(map)   => JsObject(map.map {
    case (k@("m" | "n"), x) => (s"Hello $k", x)
    case (k, v)             => (k, transform(v))
  })
  case x               => x
}
