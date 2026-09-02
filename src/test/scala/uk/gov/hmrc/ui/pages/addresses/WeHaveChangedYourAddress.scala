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

import uk.gov.hmrc.ui.helpers.AddressPages
import uk.gov.hmrc.ui.pages.BasePage

/**
   Notifier and Purchaser will only ever have one address but in theory we could have 100 different supplier addresses
   So we need to decide what supplier number we want to provide. We will make the assumption it will only ever be 1 and
   default this value however we can override this if we want to provide more.
 */
class WeHaveChangedYourAddress(addressJourney: AddressPages, supplierNumber: Int = 1) extends BasePage {
  override val pageUrl: String = s"$baseUrl/${addressJourney.getWeHaveChangedYourAddressUrl(supplierNumber)}"

  def verifyPageDisplayed(): Unit =
    validateStandardPage(
      expectedHeading = addressJourney.getWeHaveChangedYourAddressTitle
    )
}
