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

import org.openqa.selenium.{By, StaleElementReferenceException, WebDriver, WebElement}
import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait, Wait}
import org.scalatest.matchers.should.Matchers
import uk.gov.hmrc.configuration.TestEnvironment
import uk.gov.hmrc.selenium.component.PageObject
import uk.gov.hmrc.selenium.webdriver.Driver
import uk.gov.hmrc.ui.driver.BrowserDriver

import java.time.Duration

trait BasePage extends PageObject with Matchers with BrowserDriver {
  val pageUrl: String
  val baseUrl: String              = TestEnvironment.url("nova-imports-notification-frontend")
  val addressLookupBaseUrl: String = TestEnvironment.url("address-lookup-frontend")

  object Locators {
    val questionPageHeading: By = By.className("govuk-fieldset__heading")
    val inputPageHeading: By    = By.className("govuk-label-wrapper")
    val pageHeading: By         = By.className("govuk-heading-l")
    val continueButton: By      = By.className("govuk-button")
    val backButton: By          = By.className("govuk-back-link")
    val yes: By                 = By.cssSelector("label[for='value']")
    val no: By                  = By.cssSelector("label[for='value-no']")
    val option1: By             = By.cssSelector("label[for='value']")
    val option2: By             = By.cssSelector("label[for='value-2']")
    val inputField: By          = By.className("govuk-input")
    val title: By               = By.id("title")
    val firstName: By           = By.id("firstName")
    val lastName: By            = By.id("lastName")
    val phoneNumber: By         = By.id("phoneNumber")
    val mobileNumber: By        = By.id("mobileNumber")
    val cyaPageTextContent: By  = By.xpath("/html/body/div/main/div/div/dl/div[2]/dt")
  }

  private def fluentWait: Wait[WebDriver] = new FluentWait[WebDriver](Driver.instance)
    .withTimeout(Duration.ofSeconds(10))
    .pollingEvery(Duration.ofMillis(200))
    .ignoring(classOf[NoSuchElementException])
    .ignoring(classOf[StaleElementReferenceException])

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

  def verifyEndOfUrl(expectedEndOfUrl: String): Unit =
    assert(
      driver.getCurrentUrl.endsWith(expectedEndOfUrl),
      s"End of URL mismatch! Expected Url: $expectedEndOfUrl, Actual Url: ${driver.getCurrentUrl}"
    )

  /** Based on if the page had radio buttons or not dictates which page locator we need to use to grab the heading */
  def verifyQuestionPageHeading(expectedHeading: String): Unit = {
    val actualHeading = waitForVisibilityOfElement(Locators.questionPageHeading).getText
    assert(
      actualHeading == expectedHeading,
      s"Page Heading mismatch! Expected Heading: $expectedHeading, Actual Heading: $actualHeading"
    )
  }

  /** Based on if the page has input field, i.e. text box which dictates which page locator we need to use */
  def verifyInputPageHeading(expectedHeading: String): Unit = {
    val actualHeading = waitForVisibilityOfElement(Locators.inputPageHeading).getText
    assert(
      actualHeading == expectedHeading,
      s"Page Heading mismatch! Expected Heading: $expectedHeading, Actual Heading: $actualHeading"
    )
  }

  /** Finally non-interactive pages have a different heading class */
  def verifyStandardPageHeading(expectedHeading: String): Unit = {
    val actualHeading = waitForVisibilityOfElement(Locators.pageHeading).getText
    assert(
      actualHeading == expectedHeading,
      s"Page Heading mismatch! Expected Heading: $expectedHeading, Actual Heading: $actualHeading"
    )
  }

  // Some titles will be based on information provided in previous screens, for now we will partially check
  // the known information and ignore the supplier name for example
  def verifyPartialHeading(expectedStartOfHeading: String): Unit = {
    val actualHeading = waitForVisibilityOfElement(Locators.pageHeading).getText
    assert(
      actualHeading.contains(expectedStartOfHeading),
      s"Page Heading mismatch! Expected Heading: $expectedStartOfHeading, Actual Heading: $actualHeading"
    )
  }

  /** Two methods to dictate if we need to verify a question page heading or a standard page. So far in our service if
    * we have radio buttons the heading will be different CSS class as its inside a fieldset
    */
  def validateQuestionPage(expectedHeading: String): Unit = {
    verifyPageUrl()
    verifyQuestionPageHeading(expectedHeading)
  }

  def validateStandardPage(expectedHeading: String): Unit = {
    verifyPageUrl()
    verifyStandardPageHeading(expectedHeading)
  }

  /** Temp navigation work around until we have the actual flow mapped out */
  def navigateToPage(url: String): Unit = driver.navigate().to(url)

  def clickElement(locator: By): Unit =
    fluentWait.until(ExpectedConditions.elementToBeClickable(locator)).click()

  def typeInsideElement(locator: By, input: String): Unit = {
    val element = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator))
    element.clear()
    element.sendKeys(input)
  }

  def selectYes(): Unit = clickElement(Locators.yes)

  def selectNo(): Unit = clickElement(Locators.no)

  def clickContinue(): Unit = clickElement(Locators.continueButton)

  def clickBack(): Unit = clickElement(Locators.backButton)

  def selectYesAndContinue(): Unit = {
    selectYes()
    clickContinue()
  }

  def selectNoAndContinue(): Unit = {
    selectNo()
    clickContinue()
  }

  def selectOptionOneAndContinue(): Unit = {
    clickElement(Locators.option1)
    clickContinue()
  }

  def selectOptionTwoAndContinue(): Unit = {
    clickElement(Locators.option2)
    clickContinue()
  }

  def verifyElementDisplayed(locator: By): Unit = {
    val element = waitForVisibilityOfElement(locator)
    assert(
      element.isDisplayed,
      s"Expected element to be displayed, but it was not: $locator"
    )
  }

  def verifyElementNotPresent(locator: By): Unit = {
    val elements = driver.findElements(locator)
    assert(
      elements.isEmpty,
      s"Expected element not to be present, but it was found: $locator"
    )
  }
}
