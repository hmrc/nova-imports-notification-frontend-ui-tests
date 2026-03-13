package uk.gov.hmrc.ui.utils

import scala.util.Random

object RandomIdGenerator {
  def generateRandomIdentifierValue(): String = Random.alphanumeric.take(6).mkString
  def generateRandomVIN(): String             = Random.alphanumeric.take(17).mkString
}
