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

package uk.gov.hmrc.ui.pages.addresses

import org.openqa.selenium.By
import uk.gov.hmrc.ui.data.RandomValueGenerator
import uk.gov.hmrc.ui.helpers.AddressPages
import uk.gov.hmrc.ui.pages.BasePage

class SelectYourCountryOrTerritory(addressPageType: AddressPages) extends BasePage {
  override val pageUrl: String = s"$addressLookupBaseUrl/"
  val endOfUrl: String         = "/country-picker"

  object ALFPageLocators {
    val countryOrTerritory: By = By.id("countryCode")
  }

  def verifyPartialUrl(): Unit =
    verifyEndOfUrl(endOfUrl)

  def verifyPageDisplayed(): Unit = {
    val heading = addressPageType.getSelectYourCountryOrTerritoryPageTitle
    logger.info(s"Verifying page: $heading")
    verifyStandardPageHeading(expectedHeading = heading)
  }

  def inputCountryOrTerritory(): Unit = {
    logger.info(s"Inputting a Country or Territory ${this.getClass.getSimpleName}")

    var randomCountry: String = ""
    if (addressPageType == AddressPages.Supplier) randomCountry = RandomValueGenerator.getRandomEuCountry
    else randomCountry = RandomValueGenerator.getRandomNonEuCountry

    typeInsideElement(
      locator = ALFPageLocators.countryOrTerritory,
      input = randomCountry
    )
    clickContinue()
  }
}
