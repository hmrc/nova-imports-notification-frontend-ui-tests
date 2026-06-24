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

object Address {
  sealed trait Address
  final case class ManualEntryOfAddress(
    line1: String,
    line2: String,
    line3: Option[String],
    line4: Option[String],
    postcode: Option[String],
    country: Option[CountryEntryOfAddress]
  ) extends Address

  object ManualEntryOfAddress {
    val manualUkAddress: ManualEntryOfAddress = ManualEntryOfAddress(
      line1 = "10 House",
      line2 = "Test Street",
      line3 = Some("Test-Town-Upon-Tyne"),
      line4 = None,
      postcode = None,
      country = None
    )

    val manualInternationalAddress: ManualEntryOfAddress = ManualEntryOfAddress(
      line1 = "10 The Apartment",
      line2 = "Berlin",
      line3 = None,
      line4 = None,
      postcode = None,
      country = Some(CountryEntryOfAddress.countryAddress)
    )
  }

  final case class PostcodeEntryOfAddress(
    postcode: String,
    houseNameOrNumber: Option[String]
  ) extends Address

  object PostcodeEntryOfAddress {
    val postcodeAddress: PostcodeEntryOfAddress = PostcodeEntryOfAddress(
      postcode = "FX1 7RR",
      houseNameOrNumber = None
    )
  }

  final case class CountryEntryOfAddress(
    country: String
  ) extends Address

  object CountryEntryOfAddress {
    val countryAddress: CountryEntryOfAddress = CountryEntryOfAddress(
      country = "Germany"
    )
  }
}
