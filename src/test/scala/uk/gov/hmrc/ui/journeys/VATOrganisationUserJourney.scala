package uk.gov.hmrc.ui.journeys

import uk.gov.hmrc.ui.helpers.AffinityGroup
import uk.gov.hmrc.ui.pages.{AuthLoginPage, HaveYouBroughtAVehicleIntoTheUKForBusinessUse, VehicleBroughtIntoNIFromEUPage}

object VATOrganisationUserJourney {
  // TODO: Finish this flow once we have more screens
  def acquisitionBringingAVehicleInForBusinessUse(): Unit = {
    AuthLoginPage.login(AffinityGroup.OrganisationVAT)
    VehicleBroughtIntoNIFromEUPage.verifyPageDisplayed()
    VehicleBroughtIntoNIFromEUPage.selectYesAndContinue()
    HaveYouBroughtAVehicleIntoTheUKForBusinessUse.verifyPageDisplayed()
    HaveYouBroughtAVehicleIntoTheUKForBusinessUse.selectYesAndContinue()
  }

  def acquisitionVehicleForPrivateUse(): Unit = {
    AuthLoginPage.login(AffinityGroup.OrganisationVAT)
    VehicleBroughtIntoNIFromEUPage.verifyPageDisplayed()
    VehicleBroughtIntoNIFromEUPage.selectYesAndContinue()
    HaveYouBroughtAVehicleIntoTheUKForBusinessUse.verifyPageDisplayed()
    HaveYouBroughtAVehicleIntoTheUKForBusinessUse.selectNoAndContinue()
  }

  def importBringingAVehicleInForBusinessUse(): Unit = {
    AuthLoginPage.login(AffinityGroup.OrganisationVAT)
    VehicleBroughtIntoNIFromEUPage.verifyPageDisplayed()
    VehicleBroughtIntoNIFromEUPage.selectNoAndContinue()
    HaveYouBroughtAVehicleIntoTheUKForBusinessUse.verifyPageDisplayed()
    HaveYouBroughtAVehicleIntoTheUKForBusinessUse.selectYesAndContinue()
  }

  def importVehicleForPrivateUse(): Unit = {
    AuthLoginPage.login(AffinityGroup.OrganisationVAT)
    VehicleBroughtIntoNIFromEUPage.verifyPageDisplayed()
    VehicleBroughtIntoNIFromEUPage.selectNoAndContinue()
    HaveYouBroughtAVehicleIntoTheUKForBusinessUse.verifyPageDisplayed()
    HaveYouBroughtAVehicleIntoTheUKForBusinessUse.selectNoAndContinue()
  }
}
