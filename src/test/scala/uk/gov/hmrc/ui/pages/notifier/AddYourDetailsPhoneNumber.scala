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

package uk.gov.hmrc.ui.pages.notifier

import uk.gov.hmrc.ui.data.TestData
import uk.gov.hmrc.ui.pages.BasePage

object AddYourDetailsPhoneNumber extends BasePage {
  override val pageUrl: String = s"$baseUrl/contact-numbers"

  def verifyPageDisplayed(): Unit =
    verifyStandardPageHeading(
      expectedHeading = "What are your contact numbers?"
    )

  // TODO: add specific phone number / mobile numbers for different devices and area codes etc.,
  // MAYBE BUSINESS DO PHONE NUMBERS AND PI DO MOBILE
//  def inputPhoneNumber(): Unit = {
//    typeInsideElement(
//      locator = Locators.phoneNumber,
//      input = TestData.NotifierDetails.notifier.phoneNumber.get
//    )
//    clickContinue()
//  }

  def inputMobileNumber(): Unit = {
    typeInsideElement(
      locator = Locators.mobileNumber,
      input = TestData.UserDetails.NotifierDetails.notifier.mobileNumber.get
    )
    clickContinue()
  }
}
