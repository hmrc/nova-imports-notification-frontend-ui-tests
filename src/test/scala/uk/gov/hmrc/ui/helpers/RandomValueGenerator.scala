/*
 * Copyright 2026 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.ui.helpers

import uk.gov.hmrc.ui.helpers.CountryList.EuCountries

import scala.util.Random

object RandomValueGenerator {
  // Used for Authentication
  def generateRandomIdentifierValue(): String = Random.alphanumeric.take(6).mkString
  def generateRandomVIN(): String             = Random.alphanumeric.take(17).mkString

  // Used for personal details
  def generateRandomFirstName(): String = RandomData.characters(Random.between(4, 8))
  def generateRandomLastName(): String  = RandomData.characters(Random.between(8, 15))
  def generateBusinessName(): String    = RandomData.characters(Random.between(10, 20))

  // Used for contact details
  def generateRandomUserEmail(): String        = s"${RandomData.characters(Random.between(5, 20))}@example.co.uk"
  def generateRandomBusinessEmail(): String    = s"${RandomData.characters(Random.between(5, 20))}@business.com"
  def generateRandomUkMobileNumber(): String   = s"07${RandomData.numbers(9)}"
  def generateRandomUkBusinessNumber(): String = s"08${RandomData.numbers(9)}"
  def generateRandomUkLandlineNumber(): String = s"0191${RandomData.numbers(7)}"
  def generateRandomContactNumber(): String    = RandomData.numbers(11)

  // Used for EU-VAT details
  def generateRandomEuVatNumber(euState: CountryList.EuCountries): String =
    RandomData.getEuMemberStateVatRegNum(euState)
}

// Generate unique data for us whereas the RandomValueGenerator is used to call the specific data / format we want
object RandomData {
  def numbers(lengthOfString: Int): String    = List.fill(lengthOfString)(Random.nextInt(10)).mkString
  def characters(lengthOfString: Int): String = List.fill(lengthOfString)(('a' + Random.nextInt(26)).toChar).mkString

  def alphaNumericNoIO(length: Int): String = {
    val chars = "ABCDEFGHJKLMNPQRSTUVWXYZ0123456789"
    List.fill(length)(chars(Random.nextInt(chars.length))).mkString
  }

  // Used to return valid VAT-registration numbers for the EU member states that fit the regex pattern we use for validation each country uses the validation documented in F22 business function documentation
  def getEuMemberStateVatRegNum(euMemberState: CountryList.EuCountries): String =
    euMemberState match {
      case EuCountries.Austria     => s"U${numbers(8)}"
      case EuCountries.Belgium     => s"0${numbers(9)}"
      case EuCountries.Bulgaria    => numbers(Random.between(9, 10))
      case EuCountries.Croatia     => numbers(11)
      case EuCountries.Cyprus      => s"${numbers(8)}${characters(1).toUpperCase}"
      case EuCountries.Czechia     => numbers(Random.between(8, 10))
      case EuCountries.Denmark     => numbers(8)
      case EuCountries.Estonia     => numbers(9)
      case EuCountries.Finland     => numbers(8)
      case EuCountries.France      => s"${alphaNumericNoIO(1)}${alphaNumericNoIO(1)}${numbers(9)}"
      case EuCountries.Germany     => numbers(9)
      case EuCountries.Greece      => numbers(9)
      case EuCountries.Hungary     => numbers(8)
      case EuCountries.Italy       => numbers(11)
      case EuCountries.Latvia      => numbers(11)
      case EuCountries.Lithuania   => numbers(if (Random.nextBoolean()) 9 else 12)
      case EuCountries.Luxembourg  => numbers(8)
      case EuCountries.Malta       => numbers(8)
      case EuCountries.Netherlands => s"${numbers(9)}B${numbers(2)}"
      case EuCountries.Holland     => s"${numbers(9)}B${numbers(2)}"
      case EuCountries.Poland      => numbers(10)
      case EuCountries.Portugal    => numbers(9)
      case EuCountries.Romania     => numbers(Random.between(2, 10))
      case EuCountries.Slovakia    => numbers(10)
      case EuCountries.Slovenia    => numbers(8)
      case EuCountries.Sweden      => numbers(12)
      case EuCountries.Spain       =>
        Random.nextInt(3) match {
          case 0 => s"${characters(1).toUpperCase}${numbers(8)}"
          case 1 => s"${numbers(8)}${characters(1).toUpperCase}"
          case 2 => s"${characters(1).toUpperCase}${numbers(7)}${characters(1).toUpperCase}"
        }
      case EuCountries.Ireland     =>
        Random.nextInt(3) match {
          case 0 => s"${numbers(7)}${characters(1).toUpperCase}"
          case 1 => s"${numbers(1)}${characters(1).toUpperCase}${numbers(5)}${characters(1).toUpperCase}"
          case 2 => s"${numbers(7)}${characters(2).toUpperCase}"
        }
    }
}
