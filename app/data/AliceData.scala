package data

import scala.io.Source

object AliceData {
  val bookText = Source.fromFile("/Users/mushtaq/projects/workshops/pict-workshop/problems/aliceInWonderland.txt").mkString
  val stopWordText = Source.fromFile("/Users/mushtaq/projects/workshops/pict-workshop/problems/stopWords.txt").mkString

  val bookRegex = """[\s|:|.|,|"]+"""
  val stopWordsRegex = "\\s+"
}
