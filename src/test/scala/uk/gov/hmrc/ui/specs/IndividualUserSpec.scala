package uk.gov.hmrc.ui.specs

import uk.gov.hmrc.ui.journeys.IndividualUserJourney

class IndividualUserSpec extends BaseSpec {
  Feature("Individual User who is a 'Private Individual' and the 'Purchaser'") {
    Scenario("A user completing an import as a private individual and as the purchaser") {
      When("the user sets out to import a vehicle as the buyer and as a private individual")
      Then("the user successfully imports a vehicle into NI")
      IndividualUserJourney.privateIndividualAsPurchaser()
    }
  }

  Feature("Individual User who is a 'Private Individual' and importing on behalf of a 'Registered Business'") {
    Scenario("A user completing an import as a private individual on behalf of a business") {
      When("the user sets out to import a vehicle as a private individual on behalf of a business")
      Then("the user successfully imports a vehicle into NI")
      IndividualUserJourney.privateIndividualOnBehalfOfBusiness()
    }
  }

  Feature("Individual User who is a 'Private Individual' on behalf of a 'Private Individual'") {
    Scenario("A user completing an import as a private individual on behalf of a private individual") {
      When("the user sets out to import a vehicle on the behalf of a private individual")
      Then("the user successfully imports a vehicle into NI")
      IndividualUserJourney.privateIndividualOnBehalfOfPrivateIndividual()
    }
  }

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
