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

import org.openqa.selenium.{By, JavascriptExecutor, WebDriver, WebElement}
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
    val pageHeading: By = By.className("govuk-heading-l")
    val continueButton: By = By.className("govuk-button")
    val backButton: By = By.className("govuk-back-link")
    val yes: By = By.id("value")
    val no: By = By.id("value-no")
  }

  private def fluentWait: Wait[WebDriver] = new FluentWait[WebDriver](Driver.instance)
    .withTimeout(Duration.ofSeconds(2))
    .pollingEvery(Duration.ofMillis(200))

  def waitForUrl(expectedUrl: String): Unit = fluentWait.until(ExpectedConditions.urlToBe(expectedUrl))

  def waitForVisibilityOfElement(locator: By): WebElement = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator))

  def verifyPageUrl(expectedUrl: String): Unit = {
    waitForUrl(expectedUrl)
    assert(
      driver.getCurrentUrl.contains(expectedUrl),
      s"Page URL mismatch! Expected Url: $expectedUrl, Actual Url: ${driver.getCurrentUrl}"
    )
  }

  def verifyPageHeading(expectedHeading: String): Unit = {
    waitForVisibilityOfElement(Locators.pageHeading)
    assert(
      driver.getTitle == expectedHeading,
      s"Page header mismatch! Expected Heading: $expectedHeading, Actual Heading: ${driver.findElement(Locators.pageHeading).getText}"
    )
  }

  def validatePage(expectedUrl: String, expectedHeading: String): Unit = {
    verifyPageUrl(expectedUrl)
    verifyPageHeading(expectedHeading)
  }

  def selectYes(): Unit = {
    val executor = driver.asInstanceOf[JavascriptExecutor]
    executor.executeScript("arguments[0].click()", Locators.yes)
  }

  def selectNo(): Unit = {
    val executor = driver.asInstanceOf[JavascriptExecutor]
    executor.executeScript("arguments[1].click()", Locators.no)
  }

  def clickContinue(): Unit = {
    click(Locators.continueButton)
  }
}