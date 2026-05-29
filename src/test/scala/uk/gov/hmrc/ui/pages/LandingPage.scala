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

object LandingPage extends BasePage {
  override val pageUrl: String = s"$baseUrl/notification-of-vehicle-arrivals"

  object PageLocators {
    val createANewNotificationLink: By       = By.xpath("//a[normalize-space()='Create a new notification']")
    val updateASubmittedNotificationLink: By = By.xpath("//a[normalize-space()='Update a submitted notification']")
    val manageASavedNotificationLink: By     = By.xpath("//a[normalize-space()='Manage a saved notification']")
    val noSavedNotificationText: By          = By.xpath("//p[normalize-space()='You do not have a saved notifications']")
    val manageYourClients: By = By.xpath("//p[normalize-space()='Manage your clients']")
  }

  def verifyPageDisplayed(): Unit =
    validateStandardPage(expectedHeading = "Notification of Vehicle Arrivals (NOVA)")

  def createANewNotification(): Unit =
    click(PageLocators.createANewNotificationLink)

  def updateASubmittedNotification(): Unit =
    click(PageLocators.updateASubmittedNotificationLink)

  def manageASavedNotificationForUserWithDraft(): Unit =
    click(PageLocators.manageASavedNotificationLink)

  def verifyManageASavedNotificationDisabled(): Unit =
    verifyElementDisplayed(PageLocators.noSavedNotificationText)

  def manageYourClients(): Unit =
    click(PageLocators.manageYourClients)
}
