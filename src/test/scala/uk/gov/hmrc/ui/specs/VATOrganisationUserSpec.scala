package uk.gov.hmrc.ui.specs

import uk.gov.hmrc.ui.journeys.VATOrganisationUserJourney

class VATOrganisationUserSpec extends BaseSpec {
  Feature("VAT Business User who is completing an acquisition for business use") {
    Scenario("A user completing a notification for an acquisition where they're bringing a vehicle in for business use") {
      When("the user selects yes on IQ1.0 and yes on OQ1.0")
      Then("the user has successfully submitted a notification")
      VATOrganisationUserJourney.acquisitionBringingAVehicleInForBusinessUse()
    }
  }

  Feature("VAT Business User who is completing an acquisition for private use") {
    Scenario("A user completing a notification for an acquisition where they're bringing a vehicle in for private use") {
      When("the user selects yes on IQ1.0 and no on OQ1.0")
      Then("the user has successfully submitted a notification")
      VATOrganisationUserJourney.acquisitionVehicleForPrivateUse()
    }
  }

  Feature("VAT Business User who is completing an import for business use") {
    Scenario("A user completing a notification for an import where they're bringing a vehicle in for business use") {
      When("the user selects no on IQ1.0 and yes on OQ1.0")
      Then("the user has successfully submitted a notification")
      VATOrganisationUserJourney.importBringingAVehicleInForBusinessUse()
    }
  }

  Feature("VAT Business User who is completing an import for private use") {
    Scenario("A user completing a notification for an import where they're bringing a vehicle in for private use") {
      When("the user selects no on IQ1.0 and no on OQ1.0")
      Then("the user has successfully submitted a notification")
      VATOrganisationUserJourney.importVehicleForPrivateUse()
    }
  }
}