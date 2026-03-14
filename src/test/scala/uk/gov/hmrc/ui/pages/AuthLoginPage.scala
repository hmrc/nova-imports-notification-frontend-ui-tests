package uk.gov.hmrc.ui.pages

import org.openqa.selenium.By
import uk.gov.hmrc.configuration.TestEnvironment
import uk.gov.hmrc.ui.helpers.AffinityGroup

object AuthLoginPage extends BasePage {
  override val pageUrl: String = TestEnvironment.url("auth-login-stub")
  def serviceUrl: String       = TestEnvironment.url("nova-imports-notification-frontend")
  def pageTitle: String        = "Authority Wizard"

  val redirectUrl: By    = By.id("redirectionUrl")
  val affinityGroup: By  = By.id("affinityGroupSelect")
  val enrolmentKey: By   = By.id(s"enrolment[0].name") // Enrolment Key
  val enrolmentId: By    = By.name(s"enrolment[0].taxIdentifier[0].name") // Identifier Name
  val enrolmentValue: By = By.name(s"enrolment[0].taxIdentifier[0].value") // Identifier Value
  val btnSubmit: By      = By.id("submit")

  def fillAuthInputs(affGroup: AffinityGroup): Unit = {
    driver.findElement(redirectUrl).sendKeys(serviceUrl)
    driver.findElement(affinityGroup).sendKeys(affGroup.getAffinityGroup)
    driver.findElement(enrolmentKey).sendKeys(affGroup.getEnrolmentKey)
    driver.findElement(enrolmentId).sendKeys(affGroup.getIdentifierName)
    driver.findElement(enrolmentValue).sendKeys(affGroup.getIdentifierValue)
  }

  def login(affinityGroup: AffinityGroup): Unit = {
    AuthLoginPage.goToPage(pageUrl)
    fillAuthInputs(affinityGroup)
    click(btnSubmit)
  }
}
