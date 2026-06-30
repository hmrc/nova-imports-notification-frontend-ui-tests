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

  Feature("VAT Agent User who is completing a notification on their own behalf") {
    Scenario("An agent is completing a notification for themselves") {
      When("the agent selects on create a new notification from the landing page")
      Then("the agent successfully submits a notification")
      VATAgentUserJourney.agentNotifyingOnBehalfOfThemself()
    }
  }
}
