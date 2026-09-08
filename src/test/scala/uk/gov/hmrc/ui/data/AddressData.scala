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

import uk.gov.hmrc.ui.helpers.CountryList
import uk.gov.hmrc.ui.models.CountryOrTerritoryAddress.CountryOrTerritoryAddressDetails
import uk.gov.hmrc.ui.models.FullAddress.FullAddressDetails
import uk.gov.hmrc.ui.models.PostcodeAddress.PostcodeAddressDetails

import scala.util.Random

// The following data will be used for manual entry of address information (ALF screens)
// To hit all variations of screens Notifier Address will use the postcode search page
// Purchaser Address will use the manual entry of address page
// Supplier Address will use the Non-UK flow and use the Country Or Territory search page
object AddressData {
  object ManualEntryOfAddress {
    val purchaserUkAddress = FullAddressDetails(
      line1 = "The Warehouse",
      line2 = "Industrial Park",
      line3 = Some("Test Street"),
      line4 = Some("Test Town"),
      postcode = None,
      country = None
    )

    // We use countryOrTerritory and on the CountryOrTerritory search pages this will populate the country field for us
    // but the next screen we need to manually enter the rest of the address information
    val supplierInternationalAddress = FullAddressDetails(
      line1 = "Car Factory",
      line2 = "Industrial Park",
      line3 = None,
      line4 = None,
      postcode = None,
      country = None
    )
  }

  // Postcode details are from the address-lookup API documentation, there are a bunch of fake addresses to use
  object PostcodeEntryOfAddress {
    val notifierAddress = PostcodeAddressDetails(
      postcode = "FX1 7RR",
      houseNameOrNumber = None
    )
  }

  object CountryOrTerritoryEntryOfAddress {
    val supplierCountry = CountryOrTerritoryAddressDetails(
      countryOrTerritory =
        CountryList.EuCountries.values(Random.nextInt(CountryList.EuCountries.values.length)).toString
    )
  }
}
