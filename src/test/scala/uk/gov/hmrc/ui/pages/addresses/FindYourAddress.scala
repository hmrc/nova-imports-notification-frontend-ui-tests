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
import uk.gov.hmrc.ui.data.TestData
import uk.gov.hmrc.ui.helpers.AddressPages
import uk.gov.hmrc.ui.pages.BasePage

object FindYourAddress extends BasePage {
  override val pageUrl: String = s"$addressLookupBaseUrl/"
  val endOfUrl: String         = "/lookup"

  object ALFPageLocators {
    val postcode: By          = By.id("postcode")
    val houseNameOrNumber: By = By.id("filter")
  }

  def verifyPartialUrl(): Unit =
    verifyEndOfUrl(endOfUrl)

  def verifyPageDisplayed(addressPageType: AddressPages): Unit =
    verifyStandardPageHeading(
      expectedHeading = addressPageType.getFindYourAddressPageTitle
    )

  def inputUserAddressForSearch(): Unit = {
    typeInsideElement(
      locator = ALFPageLocators.postcode,
      input = TestData.AddressDetails.PostcodeEntryOfAddress.postcodeAddress.postcode
    )
    clickContinue()
  }
}
