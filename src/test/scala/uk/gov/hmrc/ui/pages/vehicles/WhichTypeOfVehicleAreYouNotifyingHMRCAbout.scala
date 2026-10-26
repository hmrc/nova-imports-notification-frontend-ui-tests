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

import org.openqa.selenium.By
import uk.gov.hmrc.ui.helpers.NotificationType
import uk.gov.hmrc.ui.pages.BasePage

class WhichTypeOfVehicleAreYouNotifyingHMRCAbout(
  notificationType: NotificationType,
  notificationNumber: Int = 1,
  vehicleNumber: Int = 1
) extends BasePage {
  override val pageUrl: String =
    s"$baseUrl/${notificationType.url}/$notificationNumber/vehicle/$vehicleNumber/vehicle-type"

  object PageLocators {
    val tractor: By      = By.cssSelector("label[for='value']")
    val car: By          = By.cssSelector("label[for='value-2']")
    val construction: By = By.cssSelector("label[for='value-3']")
    val hcv: By          = By.cssSelector("label[for='value-4']")
    val lcv: By          = By.cssSelector("label[for='value-5']")
    val motorcycle: By   = By.cssSelector("label[for='value-6']")
    val motorCaravan: By = By.cssSelector("label[for='value-7']")
  }

  def verifyPageDisplayed(): Unit = {
    logger.info(s"Verifying page: ${this.getClass.getSimpleName}")
    verifyQuestionPageHeading(
      expectedHeading = "Which type of vehicle are you notifying HMRC about?"
    )
  }

  // TODO:
  def chooseVehicleToNotifyAbout(): Unit = {}
}
