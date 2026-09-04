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

package uk.gov.hmrc.ui.pages.common

import uk.gov.hmrc.ui.pages.BasePage

class VehicleBroughtIntoNIFromEUPage(isVatUser: Boolean) extends BasePage {
  override val pageUrl: String = s"$baseUrl/vehicle-from-eu-to-northern-ireland"
  val heading: String          =
    if (isVatUser) "Is this notification for a vehicle brought into Northern Ireland from an EU country?"
    else "Notifying for a vehicle brought into Northern Ireland"

  def verifyPageDisplayed(): Unit =
    if (isVatUser) validateQuestionPage(expectedHeading = heading)
    else validateStandardPage(expectedHeading = heading)
}
