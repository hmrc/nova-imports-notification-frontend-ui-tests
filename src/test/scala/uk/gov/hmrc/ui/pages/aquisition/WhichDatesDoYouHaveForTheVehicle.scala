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

package uk.gov.hmrc.ui.pages.aquisition

import org.openqa.selenium.By
import uk.gov.hmrc.ui.helpers.Dates
import uk.gov.hmrc.ui.helpers.Dates.SelectedDates
import uk.gov.hmrc.ui.pages.BasePage

class WhichDatesDoYouHaveForTheVehicle(supplierNumber: Int = 1, vehicleNumber: Int = 1) extends BasePage {
  override val pageUrl: String = s"$baseUrl/supplier/$supplierNumber/vehicle/$vehicleNumber/vehicle-dates"

  object PageLocators {
    val dateVehicleWasFirstRegistered: By = By.id("value_0")
    val dateVehicleMadeAvailable: By      = By.id("value_1")
    val purchaseInvoiceDate: By           = By.id("value_2")
    val noIDontHaveAnyDates: By           = By.id("value_3")
  }

  def verifyPageDisplayed(): Unit = {
    logger.info(s"Verifying page: ${this.getClass.getSimpleName}")
    verifyQuestionPageHeading(
      expectedHeading = "Which dates do you have for the vehicle?"
    )
  }

  def selectDates(datesToAdd: Seq[SelectedDates]): Unit = {
    if (datesToAdd.isEmpty) selectNoDates()
    datesToAdd.foreach {
      case SelectedDates.FirstRegistration => selectDateVehicleWasRegistered()
      case SelectedDates.MadeAvailable     => selectDateMadeAvailable()
      case SelectedDates.PurchaseInvoice   => selectPurchaseInvoice()
      case SelectedDates.NoDatesProvided   => selectNoDates()
    }
    clickContinue()
  }

  private def selectDateVehicleWasRegistered(): Unit =
    clickElement(PageLocators.dateVehicleWasFirstRegistered)

  private def selectDateMadeAvailable(): Unit =
    clickElement(PageLocators.dateVehicleMadeAvailable)

  private def selectPurchaseInvoice(): Unit =
    clickElement(PageLocators.purchaseInvoiceDate)

  def selectNoDates(): Unit =
    clickElement(PageLocators.noIDontHaveAnyDates)
}
