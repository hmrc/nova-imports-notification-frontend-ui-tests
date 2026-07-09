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
import uk.gov.hmrc.ui.data.TestData

object AddPurchaserDetailsName extends BasePage {
  object PageLocators {
    val title: By     = By.xpath("/html/body/div/main/div/div/form/div[1]/input")
    val firstName: By = By.xpath("/html/body/div/main/div/div/form/div[2]/input")
    val lastName: By  = By.xpath("/html/body/div/main/div/div/form/div[3]/input")
  }

  override val pageUrl: String = s"$baseUrl/purchaser-name"

  def verifyPageDisplayed(): Unit =
    verifyStandardPageHeading(
      expectedHeading = "What is the purchaser’s name?"
    )

  def inputUserDetails(): Unit = {
    typeInsideElement(PageLocators.title, TestData.UserDetails.SupplierDetails.individualSupplier.userDetails.title)
    typeInsideElement(
      PageLocators.firstName,
      TestData.UserDetails.SupplierDetails.individualSupplier.userDetails.firstName
    )
    typeInsideElement(
      PageLocators.lastName,
      TestData.UserDetails.SupplierDetails.individualSupplier.userDetails.lastName
    )
    clickContinue()
  }
}
