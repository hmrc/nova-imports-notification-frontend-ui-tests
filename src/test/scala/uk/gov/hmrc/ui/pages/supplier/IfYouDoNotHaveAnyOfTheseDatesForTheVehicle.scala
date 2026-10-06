package uk.gov.hmrc.ui.pages.supplier

import uk.gov.hmrc.ui.pages.BasePage

class IfYouDoNotHaveAnyOfTheseDatesForTheVehicle(supplierNumber: Int = 1, vehicleNumber: Int = 1) extends BasePage {
  override val pageUrl: String = s"$baseUrl/supplier/$supplierNumber/vehicle/$vehicleNumber/no-vehicle-dates"

  def verifyPageDisplayed(): Unit = {
    logger.info(s"Verifying page: ${this.getClass.getSimpleName}")
    verifyStandardPageHeading(
      expectedHeading = "If you do not have any of the dates for the vehicle"
    )
  }
}
