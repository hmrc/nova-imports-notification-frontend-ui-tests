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
import uk.gov.hmrc.ui.helpers.{NotificationType, VehicleType}
import uk.gov.hmrc.ui.pages.BasePage

class EnterVehicleDetails(
  notificationType: NotificationType,
  notificationNumber: Int = 1,
  vehicleNumber: Int = 1,
  vehicleType: VehicleType
) extends BasePage {
  override val pageUrl: String =
    s"$baseUrl/${notificationType.url}/$notificationNumber/vehicle/$vehicleNumber/${vehicleType.url}"

  object PageLocators {
    val make: By               = By.cssSelector("label[for='make']")
    val model: By              = By.cssSelector("label[for='model']")
    val derivative: By         = By.cssSelector("label[for='derivative']")
    val bhp: By                = By.cssSelector("label[for='brakeHorsepower']")
    val trim: By               = By.cssSelector("label[for='trim']")
    val bodyType: By           = By.cssSelector("label[for='bodyType']")
    val hcvBodyType: By        = By.cssSelector("label[for='hcvType']")
    val motorcycleBodyType: By = By.cssSelector("label[for='motorcycleType']")
    val cabType: By            = By.cssSelector("label[for='cabType']")
    val motorcycleVersion: By  = By.cssSelector("label[for='motorcycleVersion']")
    val motorcycleStyle: By    = By.cssSelector("label[for='motorcycleStyle']")
    val transmission: By       = By.cssSelector("label[for='transmission']")
    val fuelType: By           = By.cssSelector("label[for='fuelType']")
    val engineSize: By         = By.cssSelector("label[for='engineSize']")
    val version: By            = By.cssSelector("label[for='version']")
    val makeOfBaseVehicle: By  = By.cssSelector("label[for='makeOfBaseVehicle']")
  }

  def verifyPageDisplayed(): Unit = {
    logger.info(s"Verifying page: ${this.getClass.getSimpleName}")
    verifyStandardPageHeading(
      expectedHeading = vehicleType.heading
    )
  }

  // TODO: ADD THE VEHICLE DETAILS

}
