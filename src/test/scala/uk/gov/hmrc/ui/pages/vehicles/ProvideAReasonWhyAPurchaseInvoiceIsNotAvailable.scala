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

package uk.gov.hmrc.ui.pages.vehicles

import uk.gov.hmrc.ui.data.RandomValueGenerator
import uk.gov.hmrc.ui.pages.BasePage

class ProvideAReasonWhyAPurchaseInvoiceIsNotAvailable(supplierNumber: Int = 1, vehicleNumber: Int = 1)
    extends BasePage {
  override val pageUrl: String = s"$baseUrl/supplier/$supplierNumber/vehicle/$vehicleNumber/no-purchase-invoice-reason"

  def verifyPageDisplayed(): Unit = {
    logger.info(s"Verifying page: ${this.getClass.getSimpleName}")
    verifyInputPageHeading(
      expectedHeading = "Provide a reason why a purchase invoice is not available"
    )
  }

  def inputReasonForNoInvoice(): Unit = {
    val reason = RandomValueGenerator.generateReasonForNoPurchaseInvoice
    logger.info(s"Entering the random value $reason for reason of no purchase invoice")
    typeInsideElement(Locators.characterCountInput, reason)
    clickContinue()
  }
}
