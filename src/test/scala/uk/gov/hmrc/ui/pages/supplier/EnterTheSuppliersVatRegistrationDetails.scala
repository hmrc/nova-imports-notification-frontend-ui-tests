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

package uk.gov.hmrc.ui.pages.supplier

import org.openqa.selenium.By
import uk.gov.hmrc.ui.data.RandomValueGenerator
import uk.gov.hmrc.ui.helpers.CountryList
import uk.gov.hmrc.ui.pages.BasePage

class EnterTheSuppliersVatRegistrationDetails(supplierNumber: Int = 1) extends BasePage {
  override val pageUrl: String = s"$baseUrl/supplier/$supplierNumber/supplier-vat-registration-details"

  def verifyPageDisplayed(): Unit =
    logger.info(s"Verifying page: ${this.getClass.getSimpleName}")
    verifyStandardPageHeading(
      expectedHeading = "Enter the supplier’s VAT registration details"
    )

  def inputCountryAndVatNumber(): Unit = {
    val country   = RandomValueGenerator.getRandomEuCountry
    val vatNumber = RandomValueGenerator.generateRandomEuVatNumber(CountryList.EuCountries.valueOf(country))

    logger.info(s"About to enter a random country: $country and it's random VAT number: $vatNumber")
    typeInsideElement(By.id("countryCode"), country)
    typeInsideElement(By.id("vatNumber"), vatNumber)
    clickContinue()
  }
}
