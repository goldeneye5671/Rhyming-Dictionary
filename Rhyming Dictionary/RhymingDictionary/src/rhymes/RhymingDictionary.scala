package rhymes

import scala.io.Source

object RhymingDictionary {

  var map:Map[String, List[String]] = Map()

  def getSounds(dictionaryFilename: String, word: String): List[String] = {
    populateMap(dictionaryFilename)
    return map.getOrElse(word, List[String]())
  }

  def isRhymeSounds(listOfStringsOne:List[String], listOfStringsTwo:List[String]):Boolean = {
    var soundsOne:List[String] = List()
    var soundsTwo:List[String] = List()
    //determines if program has hit a voul
    var voulHit = false

    //goes through the first list of pronunciations in reverse
    if(listOfStringsOne.length > 0 ) {
      for (sound <- listOfStringsOne){
        if(!voulHit){
          if(sound.contains('0') || sound.contains('1') || sound.contains('2')){
            voulHit = true
            var split = sound.split("")
            var newString:String = split(0) + split(1)
            soundsOne = soundsOne :+ newString
          }else{
            soundsOne = soundsOne :+ sound
          }
        }
      }
    }

    voulHit = false
    if (listOfStringsTwo.length > 0) {
      for(sound <- listOfStringsTwo){
        if(!voulHit){
          if(sound.contains('0') || sound.contains('1') || sound.contains('2')){
            voulHit = true
            var split = sound.split("")
            var newString:String = split(0) + split(1)
            soundsTwo = soundsTwo :+ newString
          }else{
            soundsTwo = soundsTwo :+ sound
          }
        }
      }
    }

    if (soundsOne.length > 0 || soundsTwo.length > 0){
      if (soundsOne == soundsTwo){
        return true
      }
      return false
    }else{
      return false
    }
  }

  def isRhyme(dictionaryFileName:String, wordOne:String, wordTwo:String): Boolean = {
    val wordOneSounds:List[String] = getSounds(dictionaryFileName, wordOne)
    val wordTwoSounds:List[String] = getSounds(dictionaryFileName, wordTwo)
    return isRhymeSounds(wordOneSounds, wordTwoSounds)
  }

  def findRhymes(dictionaryFileName:String, wordToFind:String):List[String] = {
    populateMap(dictionaryFileName)
    var listOfRhymingWords:List[String] = List()
    for (k <-map.keys) {
      if (isRhyme(dictionaryFileName, wordToFind.toUpperCase(), k.toUpperCase())){
        listOfRhymingWords = listOfRhymingWords :+ k
        println(listOfRhymingWords)
      }
    }
    listOfRhymingWords
  }

  def populateMap(dictionaryFileName:String):Unit={
    val file = Source.fromFile(dictionaryFileName)
      if(map.size == 0){
        for (line <- file.getLines()){
          var mybool = false
          var myList:List[String] = List()
          if (line(0) != ';'){
            var splitLine = line.split(" ")
            for (item <- splitLine.reverse){
              if (!mybool){
                if (item == ""){
                  mybool = true
                }else{
                  myList = myList :+ item
                }
              }
            }
            map += (splitLine(0) -> myList)
          }
        }
        println("map populated")
      }
    }

  def main(args: Array[String]): Unit = {
    val dictionaryFileName: String = "data/cmudict-0.7b"
  }

}
