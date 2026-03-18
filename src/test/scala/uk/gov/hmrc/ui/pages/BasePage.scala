/*
 * Copyright 2023 HM Revenue & Customs
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

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait, Wait}
import org.scalatest.matchers.should.Matchers
import uk.gov.hmrc.configuration.TestEnvironment
import uk.gov.hmrc.selenium.component.PageObject
import uk.gov.hmrc.selenium.webdriver.Driver
import uk.gov.hmrc.ui.driver.BrowserDriver

import java.time.Duration

trait BasePage extends PageObject with Matchers with BrowserDriver {
  val pageUrl: String
  val baseUrl: String = TestEnvironment.url("nova-imports-notification-frontend")

  object Locators {
    val pageHeading: By    = By.className("govuk-heading-l")
    val continueButton: By = By.className("govuk-button")
    val backButton: By     = By.className("govuk-back-link")
    val yes: By            = By.id("value")
    val no: By             = By.id("value-no")
  }

  private def fluentWait: Wait[WebDriver] = new FluentWait[WebDriver](Driver.instance)
    .withTimeout(Duration.ofSeconds(2))
    .pollingEvery(Duration.ofMillis(200))

  def waitForUrl(expectedUrl: String): Unit = fluentWait.until(ExpectedConditions.urlToBe(expectedUrl))

  def waitForVisibilityOfElement(locator: By): WebElement =
    fluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator))

  def goToPage(url: String): Unit = driver.navigate().to(url)

  def verifyPageUrl(): Unit = {
    waitForUrl(pageUrl)
    assert(
      driver.getCurrentUrl.contains(pageUrl),
      s"Page URL mismatch! Expected Url: $pageUrl, Actual Url: ${driver.getCurrentUrl}"
    )
  }

  def verifyPageHeading(expectedHeading: String): Unit = {
    val actualHeading = waitForVisibilityOfElement(Locators.pageHeading).getText
    assert(
      actualHeading == expectedHeading,
      s"Page Heading mismatch! Expected Heading: $expectedHeading, Actual Heading: $actualHeading"
    )
  }

  def validatePage(expectedHeading: String): Unit = {
    verifyPageUrl()
    verifyPageHeading(expectedHeading)
  }

  def selectYes(): Unit = click(Locators.yes)

  def selectNo(): Unit = click(Locators.no)

  def clickContinue(): Unit = click(Locators.continueButton)

  def clickBack(): Unit = click(Locators.backButton)

  def selectYesAndContinue(): Unit = {
    selectYes()
    clickContinue()
  }

  def selectNoAndContinue(): Unit = {
    selectNo()
    clickContinue()
  }
}
