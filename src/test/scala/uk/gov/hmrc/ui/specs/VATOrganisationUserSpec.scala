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

///*
// * Copyright 2026 HM Revenue & Customs
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *     http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package uk.gov.hmrc.ui.specs
//
//import uk.gov.hmrc.ui.journeys.VATOrganisationUserJourney
//
//class VATOrganisationUserSpec extends BaseSpec {
//  Feature("VAT Business User who is completing an acquisition for business use") {
//    Scenario(
//      "A user completing a notification for an acquisition where they're bringing a vehicle in for business use"
//    ) {
//      When("the user selects yes on IQ1.0 and yes on OQ1.0")
//      Then("the user has successfully submitted a notification")
//      VATOrganisationUserJourney.acquisitionBringingAVehicleInForBusinessUse()
//    }
//  }
//
//  Feature("VAT Business User who is completing an acquisition for private use") {
//    Scenario(
//      "A user completing a notification for an acquisition where they're bringing a vehicle in for private use"
//    ) {
//      When("the user selects yes on IQ1.0 and no on OQ1.0")
//      Then("the user has successfully submitted a notification")
//      VATOrganisationUserJourney.acquisitionVehicleForPrivateUse()
//    }
//  }
//
//  Feature("VAT Business User who is completing an import for business use") {
//    Scenario("A user completing a notification for an import where they're bringing a vehicle in for business use") {
//      When("the user selects no on IQ1.0 and yes on OQ1.0")
//      Then("the user has successfully submitted a notification")
//      VATOrganisationUserJourney.importBringingAVehicleInForBusinessUse()
//    }
//  }
//
//  Feature("VAT Business User who is completing an import for private use") {
//    Scenario("A user completing a notification for an import where they're bringing a vehicle in for private use") {
//      When("the user selects no on IQ1.0 and no on OQ1.0")
//      Then("the user has successfully submitted a notification")
//      VATOrganisationUserJourney.importVehicleForPrivateUse()
//    }
//  }
//}
