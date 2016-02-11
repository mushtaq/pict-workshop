
def concat(s1: Option[String], s2: Option[String]): Option[String] = {
  if(s1.isInstanceOf[Some[String]] && s2.isInstanceOf[Some[String]]) {
    Some(s1.asInstanceOf[Some[String]].x + s2.asInstanceOf[Some[String]].x)
  } else if(s1 == None) {
    s2
  } else {
    s1
  }
}

concat(Some("a"), Some("b"))
concat(Some("a"), None)
concat(None, Some("b"))
concat(None, None)





