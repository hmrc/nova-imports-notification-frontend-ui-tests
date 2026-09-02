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
import uk.gov.hmrc.ui.pages.BasePage

object EnterTheSuppliersVatRegistrationDetails extends BasePage {
  override val pageUrl: String = s"$baseUrl/supplier/1/supplier-vat-registration-details"

  object PageLocators {
    val country: By = By.id("countryCode")
    val vatNum: By  = By.id("vatNumber")
  }

  // TODO: should this actually not be a input heading type, see if prototype + service need changing?
  def verifyPageDisplayed(): Unit =
    verifyStandardPageHeading(
      expectedHeading = "Enter the supplier’s VAT registration details"
    )

  // TODO: Need test data for this! Come back and refactor
  def inputCountryAndVatNumber(): Unit = {
    typeInsideElement(PageLocators.country, "Croatia")
    typeInsideElement(PageLocators.vatNum, "00000000000")
    clickContinue()
  }
}
