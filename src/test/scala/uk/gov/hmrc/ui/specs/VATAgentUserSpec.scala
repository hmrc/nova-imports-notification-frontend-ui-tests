/*
 * Copyright 2026 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.ui.specs

import uk.gov.hmrc.ui.journeys.VATAgentUserJourney

class VATAgentUserSpec extends BaseSpec {
  // TODO: TOO FLAKY REIMPLEMENT WHEN FLOW IS AVAILABLE SOMETIMES TEST PAGE WORKS OTHER TIMES IT DOESNT
//  Feature("VAT Agent User who is completing a notification on behalf of their client") {
//    Scenario("An agent is completing a notification for a selected client") {
//      When("the agent selects an authorised client")
//      Then("the agent successfully submits a notification on their behalf")
//      VATAgentUserJourney.agentNotifyingOnBehalfOfClient()
//    }
//  }

  Feature("VAT Agent User who is a 'Private Individual' and the 'Notifier'") {
    Scenario("An agent is completing a notification as a private individual and as the purchaser") {
      When("the agent selects on create a new notification from the landing page")
      Then("the agent successfully submits a notification")
      VATAgentUserJourney.SelfNotifying.Acquisition.notifyingAsAPrivateIndividualAsANotifier()
    }
  }

  Feature("VAT Agent User who is a 'Business' and the 'Notifier'") {
    Scenario("An agent is completing a notification as a business and as the purchaser") {
      When("the agent selects on create a new notification from the landing page")
      Then("the agent successfully submits a notification")
      VATAgentUserJourney.SelfNotifying.Acquisition.notifyingAsABusinessAsANotifier()
    }
  }

  Feature("VAT Agent User who is a 'Private Individual' and importing on behalf of a 'Registered Business'") {
    Scenario("A user completing an import as a private individual on behalf of a business") {
      When("the user sets out to import a vehicle as a private individual on behalf of a business")
      Then("the user successfully imports a vehicle into NI")
      VATAgentUserJourney.SelfNotifying.Acquisition.notifyingAsAIndividualOnBehalfOfABusiness()
    }
  }

  Feature("VAT Agent User who is a 'Private Individual' on behalf of a 'Private Individual'") {
    Scenario("A user completing an import as a private individual on behalf of a private individual") {
      When("the user sets out to import a vehicle on the behalf of a private individual")
      Then("the user successfully imports a vehicle into NI")
      VATAgentUserJourney.SelfNotifying.Acquisition.notifyingAsAIndividualOnBehalfOfAIndividual()
    }
  }

  Feature("VAT Agent User who is a 'Business' on behalf of a 'Business'") {
    Scenario("A user completing an acquisition as a business on behalf of a business") {
      When("the user sets out to import a vehicle on the behalf of a business")
      Then("the user successfully imports a vehicle into NI")
      VATAgentUserJourney.SelfNotifying.Acquisition.notifyingAsABusinessOnBehalfOfABusiness()
    }
  }

  Feature("VAT Agent User who is a 'Business' on behalf of a 'Private Individual'") {
    Scenario("A user completing an acquisition as a business on behalf of a private individual") {
      When("the user sets out to import a vehicle on the behalf of a individual")
      Then("the user successfully imports a vehicle into NI")
      VATAgentUserJourney.SelfNotifying.Acquisition.notifyingAsABusinessOnBehalfOfAIndividual()
    }
  }

  // TODO: TO BE IMPLEMENTED
//  Feature("VAT Agent User who is completing an import on their own behalf") {
//    Scenario("An agent is completing a notification for themselves") {
//      When("the agent selects on create a new notification from the landing page")
//      Then("the agent successfully submits a notification")
//      VATAgentUserJourney.SelfNotifying.Import.agentNotifyingOnBehalfOfThemself()
//    }
//  }
}
