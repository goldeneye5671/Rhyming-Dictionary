package tests

import org.scalatest._
import rhymes.RhymingDictionary


class TestGetSounds extends FunSuite {
  val dictionaryFileName: String = "data/cmudict-0.7b"
  test("Test TestGetSounds"){
    assert(RhymingDictionary.getSounds(dictionaryFileName,"hello") == List[String]())
    assert(RhymingDictionary.getSounds(dictionaryFileName, "zrn") == List[String]())
  }
}
