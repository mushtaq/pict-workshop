
def concat(s1: Option[String], s2: Option[String]): Option[String] = {
  (s1, s2) match {
    case (Some(x), Some(y)) => Some(x + y)
    case (None, Some(y))    => Some(y)
    case (Some(x), None)    => Some(x)
    case (None, None)       => None
  }
}
def concat2(s1: Option[String], s2: Option[String]): Option[String] = {
  (s1, s2) match {
    case (Some(x), Some(y)) => Some(x + y)
    case (None, _)          => s2
    case (_, None)          => s1
  }
}

concat(Some("a"), Some("b"))
concat(Some("a"), None)
concat(None, Some("b"))
concat(None, None)
