package tests

import org.scalatest._
import rhymes.RhymingDictionary


class TestIsRhyme extends FunSuite {
  val dictionaryFileName: String = "data/cmudict-0.7b"

  test("Test for IsRhyme"){
    assert(RhymingDictionary.isRhyme(dictionaryFileName, "fuck", "cuck") == false)
    assert(RhymingDictionary.isRhyme(dictionaryFileName, "ZURN", "NRUZ") == false)
    assert(RhymingDictionary.isRhyme(dictionaryFileName, "DUCK", "TRUCK") == true)
    assert(RhymingDictionary.isRhyme(dictionaryFileName, "HALF", "PHOTOGRAPH") == true)
    assert(RhymingDictionary.isRhyme(dictionaryFileName, "THOUSAND", "DIAMOND") == true)
    assert(RhymingDictionary.isRhyme(dictionaryFileName, "RHYME", "DEFINE") == false)
    assert(RhymingDictionary.isRhyme(dictionaryFileName, "DIAMOND", "DIAMONDS") == false)
    assert(RhymingDictionary.isRhyme(dictionaryFileName, "STAFF", "LAUGH"))
    assert(RhymingDictionary.isRhyme(dictionaryFileName, "ISLAND", "LEGEND"))
  }
}
