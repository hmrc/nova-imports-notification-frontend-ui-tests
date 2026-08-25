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

class WhichDatesDoYouHaveForTheVehicle(supplierNumber: Int, vehicleNumber: Int) extends BasePage {
  override val pageUrl: String = s"$baseUrl/supplier/$supplierNumber/vehicle/$vehicleNumber/vehicle-dates"

  object PageLocators {
    val vehicleAvailabilityDateFirstRegistration: By = By.id("value_0")
    val purchaseInvoiceDate: By                      = By.id("value_1")
    val noIDontHaveAnyDates: By                      = By.id("value_2")
  }

  def verifyPageDisplayed(): Unit =
    verifyQuestionPageHeading(
      expectedHeading = "Which dates do you have for the vehicle?"
    )
}
