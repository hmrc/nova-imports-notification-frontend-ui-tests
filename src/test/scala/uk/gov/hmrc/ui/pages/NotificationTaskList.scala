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

object NotificationTaskList extends BasePage {
  override val pageUrl: String = s"$baseUrl/create-vehicle-notification"

  object PageLocators {
    val addYourDetails: By       = By.cssSelector("a[aria-describedby='add-your-details-status']")
    val addYourDetailsStatus: By = By.id("add-your-details-status")

    val addYourAddress: By       = By.cssSelector("a[aria-describedby='add-your-address-status']")
    val addYourAddressStatus: By = By.id("add-your-address-status")

    val addVehicleDetails: By       = By.cssSelector("a[aria-describedby='add-vehicle-details-status']")
    val addVehicleDetailsStatus: By = By.id("add-vehicle-details-status")

    val readDeclaration: By = By.id("read-declaration-hint") // to-be completed
  }

  def verifyPageDisplayed(): Unit =
    validateStandardPage(expectedHeading = "Create a vehicle notification")

  def verifyTaskListWithAddress(): Unit = {
    verifyPageDisplayed()
    verifyElementDisplayed(PageLocators.addYourAddress)
  }

  def verifyTaskListWithoutAddress(): Unit = {
    verifyPageDisplayed()
    verifyElementNotPresent(PageLocators.addYourAddress)
  }

  def verifyTaskStatus(status: By, expectedStatus: String): Unit = {
    val actualStatus = waitForVisibilityOfElement(status).getText

    assert(actualStatus == expectedStatus, s"Expected status '$expectedStatus' but found '$actualStatus'")
  }

  def verifyAddYourDetailsStatus(expectedStatus: String): Unit =
    verifyTaskStatus(PageLocators.addYourDetailsStatus, expectedStatus)

  def verifyAddYourAddressStatus(expectedStatus: String): Unit =
    verifyTaskStatus(PageLocators.addYourAddressStatus, expectedStatus)

  def verifyAddVehicleDetailsStatus(expectedStatus: String): Unit =
    verifyTaskStatus(PageLocators.addVehicleDetailsStatus, expectedStatus)

  def clickAddYourDetails(): Unit =
    clickElement(PageLocators.addYourDetails)

  def clickAddYourAddress(): Unit =
    clickElement(PageLocators.addYourAddress)

  def clickAddVehicleDetails(): Unit =
    clickElement(PageLocators.addVehicleDetails)
}
