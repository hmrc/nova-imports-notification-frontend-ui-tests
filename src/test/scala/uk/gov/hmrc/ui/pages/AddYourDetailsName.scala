package uk.gov.hmrc.ui.pages

object AddYourDetailsName extends BasePage {

  override val pageUrl: String = s"$baseUrl/name"

  def verifyPageDisplayed(): Unit =
    validateQuestionPage(
      expectedHeading = "What is your name?"
    )
}