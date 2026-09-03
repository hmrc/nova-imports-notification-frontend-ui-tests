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

import org.openqa.selenium.By
import uk.gov.hmrc.ui.pages.BasePage

object NotificationTaskList extends BasePage {
  override val pageUrl: String = s"$baseUrl/create-vehicle-notification"

  object PageLocators {
    val addYourDetails: By       = By.cssSelector("a[aria-describedby='about-you-1-status']")
    val addYourDetailsStatus: By = By.id("about-you-1-status")

    val addYourAddress: By       = By.cssSelector("a[aria-describedby='about-you-2-status']")
    val addYourAddressStatus: By = By.id("about-you-2-status")

    val addPurchaserDetails: By       = By.cssSelector("a[aria-describedby='about-the-purchaser-1-status']")
    val addPurchaserDetailsStatus: By = By.id("about-the-purchaser-1-status")

    val addPurchaserAddress: By       = By.cssSelector("a[aria-describedby='about-the-purchaser-2-status']")
    val addPurchaserAddressStatus: By = By.id("about-the-purchaser-2-status")

    val addVehicleDetails: By       = By.cssSelector("a[aria-describedby='about-the-vehicles-1-status']")
    val addVehicleDetailsStatus: By = By.id("about-the-vehicles-1-status")

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

  def verifyTaskListWithPurchaserDetails(): Unit = {
    verifyPageDisplayed()
    verifyElementDisplayed(PageLocators.addPurchaserDetails)
  }

  def verifyTaskListWithoutPurchaserDetails(): Unit = {
    verifyPageDisplayed()
    verifyElementNotPresent(PageLocators.addPurchaserDetails)
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

  def verifyAddPurchaserDetailsStatus(expectedStatus: String): Unit =
    verifyTaskStatus(PageLocators.addPurchaserDetailsStatus, expectedStatus)

  def verifyAddPurchaserAddressStatus(expectedStatus: String): Unit =
    verifyTaskStatus(PageLocators.addPurchaserAddressStatus, expectedStatus)

  def clickAddYourDetails(): Unit =
    clickElement(PageLocators.addYourDetails)

  def clickAddYourAddress(): Unit =
    clickElement(PageLocators.addYourAddress)

  def clickAddPurchaserDetails(): Unit =
    clickElement(PageLocators.addPurchaserDetails)

  def clickAddPurchaserAddress(): Unit =
    clickElement(PageLocators.addPurchaserAddress)

  def clickAddVehicleDetails(): Unit =
    clickElement(PageLocators.addVehicleDetails)
}
