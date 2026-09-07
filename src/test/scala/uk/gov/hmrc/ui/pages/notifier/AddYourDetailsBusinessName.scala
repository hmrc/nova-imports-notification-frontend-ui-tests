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

object AddYourDetailsBusinessName extends BasePage {
  override val pageUrl: String = s"$baseUrl/business-name"

  def verifyPageDisplayed(): Unit =
    verifyInputPageHeading(
      expectedHeading = "What is your business name?"
    )

  // TODO: Change this data
  def inputBusinessName(): Unit = {
    typeInsideElement(
      Locators.inputField,
      TestData.UserDetails.SupplierDetails.businessSupplier.userDetails.businessName
    )
    clickContinue()
  }
}
