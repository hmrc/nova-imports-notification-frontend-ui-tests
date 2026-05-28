package uk.gov.hmrc.ui.pages

object AddYourDetailsPhoneNumber extends BasePage {
  override val pageUrl: String = s"$baseUrl/phone-number"

  def verifyPageDisplayed(): Unit =
    verifyQuestionPageHeading(
      expectedHeading = "What is your phone number?"
    )
}