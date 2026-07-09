package uk.gov.hmrc.ui.pages

import org.openqa.selenium.By
import uk.gov.hmrc.ui.data.TestData

object AddPurchaserDetailsName extends BasePage {
  object PageLocators {
    val title: By     = By.xpath("/html/body/div/main/div/div/form/div[1]/input")
    val firstName: By = By.xpath("/html/body/div/main/div/div/form/div[2]/input")
    val lastName: By  = By.xpath("/html/body/div/main/div/div/form/div[3]/input")
  }

  override val pageUrl: String = s"$baseUrl/purchaser-name"

  def verifyPageDisplayed(): Unit =
    verifyStandardPageHeading(
      expectedHeading = "What is the purchaser’s name?"
    )

  def inputUserDetails(): Unit = {
    typeInsideElement(PageLocators.title, TestData.UserDetails.SupplierDetails.individualSupplier.userDetails.title)
    typeInsideElement(PageLocators.firstName, TestData.UserDetails.SupplierDetails.individualSupplier.userDetails.firstName)
    typeInsideElement(PageLocators.lastName, TestData.UserDetails.SupplierDetails.individualSupplier.userDetails.lastName)
    clickContinue()
  }
}
