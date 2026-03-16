package uk.gov.hmrc.ui.specs

import uk.gov.hmrc.ui.journeys.IndividualUserJourney

class IndividualUserSpec extends BaseSpec {
  Feature("Individual E2E User Journey") {
    Scenario("Individual user imports vehicle to NI from EU and needs to import a vehicle") {
      When("the user answers 'no' on IQ1 and needs to make an import declaration instead")
      IndividualUserJourney.userNeedsToImportAVehicle()
    }
  }
}
