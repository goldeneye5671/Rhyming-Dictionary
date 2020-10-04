package tests

import org.scalatest._
import rhymes.RhymingDictionary

class TestIsRhymeSounds extends FunSuite {
  val dictionaryFileName: String = "data/cmudict-0.7b"

  test("check for rhyming sound lists") {
    assert(RhymingDictionary.getSounds("data/cmudict-0.7b", "fuck") == List[String]())
    assert(RhymingDictionary.isRhymeSounds(List[String]("TH", "AW1", "Z", "AH0", "N", "D"), List[String]("TH", "AW", "Z", "AH", "N", "D")) == true)
  }

}
