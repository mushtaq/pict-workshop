import data.AliceData

val words = AliceData.bookText.toLowerCase.split(AliceData.bookRegex)
val stopWords = AliceData.stopWordText.toLowerCase.split(AliceData.stopWordsRegex).toSet

words
  .filterNot(stopWords)
  .groupBy(identity)
  .mapValues(xs => xs.length)
  .toList
  .sortBy(t => -t._2)
  .take(10)


