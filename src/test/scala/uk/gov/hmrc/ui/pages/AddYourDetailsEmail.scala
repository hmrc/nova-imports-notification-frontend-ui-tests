package uk.gov.hmrc.ui.pages

object AddYourDetailsEmail extends BasePage {
  override val pageUrl: String = s"$baseUrl/email-address"

  def verifyPageDisplayed(): Unit =
    verifyQuestionPageHeading(
      expectedHeading = "What is your email address?"
    )
}
