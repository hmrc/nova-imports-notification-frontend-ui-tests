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

package uk.gov.hmrc.ui.data

import uk.gov.hmrc.ui.helpers.CountryList.EuCountries
import uk.gov.hmrc.ui.helpers.CountryList

import java.time.LocalDate
import scala.util.Random

object RandomValueGenerator {
  // Used for Authentication
  def generateRandomIdentifierValue: String = Random.alphanumeric.take(6).mkString
  def generateRandomVIN: String             = Random.alphanumeric.take(17).mkString

  // Used for personal details
  def getRandomTitle: String          = RandomData.title
  def generateRandomFirstName: String = RandomData.characters(Random.between(4, 8))
  def generateRandomLastName: String  = RandomData.characters(Random.between(8, 15))
  def generateBusinessName: String    = RandomData.characters(Random.between(10, 20))

  // Used for contact details
  def generateRandomEmail: String          = s"${RandomData.characters(Random.between(5, 20))}@example.co.uk"
  def generateRandomMobileNumber: String   = s"07${RandomData.numbers(9)}"
  def generateRandomLandlineNumber: String = s"0191${RandomData.numbers(7)}"
  def generateRandomAddressLine: String    = RandomData.characters(Random.between(1, 35))
  def getRandomPostcode: String            = RandomData.postcodes
  def getRandomEuCountry: String           =
    CountryList.EuCountries.values(Random.nextInt(CountryList.EuCountries.values.length)).toString
  def getRandomNonEuCountry: String        =
    CountryList.NonEuCountries.values(Random.nextInt(CountryList.NonEuCountries.values.length)).toString

  // Used for EU-VAT details
  def generateRandomEuVatNumber(euState: CountryList.EuCountries): String =
    RandomData.getEuMemberStateVatRegNum(euState)

  // Used for vehicle details
  def generateDateOfFirstRegistration: LocalDate = RandomData.historicDate()
  def generateDateOfArrival: LocalDate           = RandomData.last14Days()
  def generatePurchaseInvoiceDate: LocalDate     = RandomData.purchaseDate()
  def generateCountryOfFirstRegistration: String = CountryList.randomCountry().toString
  def generateTotalAmountPaid: String            = Random.between(1, 999999999999L).toString
  def generatePurchaseInvoiceNumber: String      = RandomData.alphaNumeric(Random.between(1, 20))
  def generateReasonForNoPurchaseInvoice: String = RandomData.characters(Random.between(1, 160))
}

// Generate unique data for us whereas the RandomValueGenerator is used to call the specific data / format we want
object RandomData {
  def numbers(lengthOfString: Int): String          = List.fill(lengthOfString)(Random.nextInt(10)).mkString
  def characters(lengthOfString: Int): String       = List.fill(lengthOfString)(('a' + Random.nextInt(26)).toChar).mkString
  def alphaNumeric(lengthOfString: Int): String     = Random.alphanumeric.take(lengthOfString).mkString
  def alphaNumericNoIO(lengthOfString: Int): String = {
    val chars = "ABCDEFGHJKLMNPQRSTUVWXYZ0123456789"
    List.fill(lengthOfString)(chars(Random.nextInt(chars.length))).mkString
  }

  // Used to randomly choose a title
  def title: String = {
    val titles = Seq("Mr", "Mrs", "Miss", "Master", "Ms", "Dr")
    titles(Random.nextInt(titles.length))
  }

  // Postcode works locally using test data within address-lookup so going to use a few random ones from there
  def postcodes: String =
    Random.nextInt(4) match {
      case 0 => "FX1 7RR"
      case 1 => "ZZ01 1ZZ"
      case 2 => "FX97 4TU"
      case 3 => "FX0R 3TQ"
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

  // Used to grab a random country from EU / Non-EU list for country of first registration

  /** --- Used for generating a variety of dates --- One method is used for date of registration which will be from 1980
    * -> 2025 allowing us to simulate a variety of vehicles with increasing / decreasing total miles The other method is
    * used for date of arrival and will be from the current system date - 14 days prior randomly to simulate different
    * LNP charge The final method is used for date of purchase invoice for testing purposes we are going to assume the
    * user bought the vehicle a week prior to the arrival date
    */
  def historicDate(): LocalDate = randomBetween(
    LocalDate.of(1980, 1, 1),
    LocalDate.of(2025, 12, 30)
  )

  def last14Days(): LocalDate = randomBetween(
    LocalDate.now.minusDays(14),
    LocalDate.now
  )

  def purchaseDate(): LocalDate = {
    val randomDay: LocalDate = last14Days()
    randomDay.minusWeeks(1)
  }

  private def randomBetween(start: LocalDate, end: LocalDate): LocalDate = {
    val randomDay = Random.between(start.toEpochDay, end.toEpochDay + 1)
    LocalDate.ofEpochDay(randomDay)
  }
}
