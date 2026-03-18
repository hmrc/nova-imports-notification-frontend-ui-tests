package uk.gov.hmrc.ui.specs

import uk.gov.hmrc.ui.journeys.IndividualUserJourney

class IndividualUserSpec extends BaseSpec {
  Feature("Individual User needs to make an import instead of using NoVA service") {
    Scenario("Individual user imports vehicle to NI from outside of the EU") {
      When(
        "the user answers 'no' for 'Are you completing a notification for a vehicle brought into Northern Ireland from an EU country?'"
      )
      Then("the user is directed to make an import declaration instead")
      IndividualUserJourney.userNeedsToImportAVehicleFromOutsideEU()
    }
  }
}
