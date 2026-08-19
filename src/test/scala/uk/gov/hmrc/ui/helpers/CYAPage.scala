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

package uk.gov.hmrc.ui.helpers

/** Handy method:
  *   - That can be used to get the correct URL for each unique CYA page
  *   - Can check the first variation in table content for extra confirmation we are seeing the correct CYA Page for
  *     this given journey
  */
enum CYAPage:
  case InitialQuestions, YourDetails

  def getCYAPageUrl: String = this match {
    case InitialQuestions => "initial-questions"
    case YourDetails      => "your-details"
    case YourAddress      => "your-address"
  }

object CYAPage {
  // Used to check CYA's that vary based on User Types
  def getContent(page: CYAPage, group: AffinityGroup, clientSelected: Boolean): String =
    (page, group, clientSelected) match {
      case (CYAPage.InitialQuestions, AffinityGroup.Individual, false)      =>
        "Are you a business or private individual?"
      case (CYAPage.InitialQuestions, AffinityGroup.OrganisationVAT, false) =>
        "Have you brought a vehicle into the UK for business use?"
      case (CYAPage.InitialQuestions, AffinityGroup.AgentVAT, false)        =>
        "Are you a business or private individual?"
      case (CYAPage.InitialQuestions, AffinityGroup.AgentVAT, true)         =>
        "Has your client brought a vehicle into the UK for business use?"
      case (_, _, _)                                                        => "No content matches"
    }
}
