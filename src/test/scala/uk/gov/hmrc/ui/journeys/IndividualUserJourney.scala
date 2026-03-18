package uk.gov.hmrc.ui.journeys

import uk.gov.hmrc.ui.helpers.AffinityGroup
import uk.gov.hmrc.ui.pages.{AuthLoginPage, BasePage, VehicleBroughtIntoNIFromEUPage, VehicleBroughtIntoNIFromOutsideEUPage}

object IndividualUserJourney extends BasePage {
  override val pageUrl: String                           = "" // Needed due to extending BasePage
  def userCompletesFlowWithManualEntryOfAVehicle(): Unit = {
    // TODO: This would eventually go page to page
  }

  def userCompletesFlowUpToSpreadsheetUpload(): Unit = {
    // TODO:
  }

  def userCompletesFlowAfterSpreadsheetUpload(): Unit = {
    // TODO:
  }

  def userNeedsToImportAVehicleFromOutsideEU(): Unit = {
    AuthLoginPage.login(AffinityGroup.Individual)
    VehicleBroughtIntoNIFromEUPage.verifyPageDisplayed()
    selectNoAndContinue()
    VehicleBroughtIntoNIFromOutsideEUPage.verifyPageDisplayed()
  }
}
