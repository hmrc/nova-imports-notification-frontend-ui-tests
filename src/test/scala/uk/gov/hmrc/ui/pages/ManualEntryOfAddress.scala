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

package uk.gov.hmrc.ui.pages

import org.openqa.selenium.By

object ManualEntryOfAddress extends BasePage {
  override val pageUrl: String      = s"$addressLookupBaseUrl"
  val endOfUkUrl: String            = "/edit"
  val endOfInternationalUrl: String = "/international/edit"

  object ALFPageLocators {
    val line1: By    = By.id("line1")
    val line2: By    = By.id("line2")
    val line3: By    = By.id("line3")
    val line4: By    = By.id("town")
    val postcode: By = By.id("postcode")
    val country: By  = By.id("countryName")
  }

  def verifyUkPartialUrl(): Unit =
    verifyEndOfUrl(endOfUkUrl)

  def verifyInternationalUrl(): Unit =
    verifyEndOfUrl(endOfInternationalUrl)

  def verifyPageDisplayed(): Unit =
    verifyInputPageHeading(
      expectedHeading = "Enter your address"
    )

  def inputUserAddress(): Unit = {
    val line1 = waitForVisibilityOfElement(ALFPageLocators.line1)
    val line2 = waitForVisibilityOfElement(ALFPageLocators.line2)

    line1.sendKeys("1")
    line2.sendKeys("2")
    clickContinue()
  }
}
