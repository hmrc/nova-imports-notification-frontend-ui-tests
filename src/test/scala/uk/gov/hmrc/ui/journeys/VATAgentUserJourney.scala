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

package uk.gov.hmrc.ui.journeys

import uk.gov.hmrc.ui.helpers.AffinityGroup
import uk.gov.hmrc.ui.pages.{AuthLoginPage, BeforeYouContinue, LandingPage, RetrievingYourClientList, WeCouldNotRetrieveYourClientList, YouHaveNoAuthorisedClients}

object VATAgentUserJourney {

  /** The main user journey for an Agent, they will choose a client and submit a notification on their behalf */
  def agentNotifyingOnBehalfOfClient(): Unit = {
    AuthLoginPage.login(AffinityGroup.AgentVAT)
    // TODO: LANDING PAGE (AGENT)
    // TODO: SELECT CLIENT AND CONTINUE
//    BeforeYouContinue.verifyMultipleVehiclesSectionPresent()

    // TODO: Remove once flow is actually implemented
    RetrievingYourClientList.navigateToPage(RetrievingYourClientList.pageUrl)
    RetrievingYourClientList.verifyPageDisplayed()
    // TODO: COMPLETE THE REST OF THE JOURNEY
  }

  // NOTE: Not sure if CS2.0 will actually be reachable?
  /** A short journey to reach an error page and then will end the journey */
  def agentNotifyingOnBehalfOfClientClientListFailedToLoad(): Unit = {
    AuthLoginPage.login(AffinityGroup.AgentVAT)
    // TODO: SELECT CLIENT AND CONTINUE
//    BeforeYouContinue.verifyMultipleVehiclesSectionPresent()

    // TODO: Remove once flow is actually implemented
    RetrievingYourClientList.navigateToPage(RetrievingYourClientList.pageUrl)
    RetrievingYourClientList.verifyPageDisplayed()
    // TODO: Remove once flow is actually implemented
    WeCouldNotRetrieveYourClientList.navigateToPage(WeCouldNotRetrieveYourClientList.pageUrl)
    WeCouldNotRetrieveYourClientList.verifyPageDisplayed()
  }

  /** This user will complete a notification acting as a private individual, i.e., completing a notification for
    * themselves and not on behalf of a Client
    */
  def agentNotifyingOnBehalfOfThemself(): Unit = {
    AuthLoginPage.login(AffinityGroup.AgentVAT)
    LandingPage.verifyPageDisplayed()
    LandingPage.createANewNotification()
    BeforeYouContinue.verifyMultipleVehiclesSectionNotPresent()

    // TODO: LANDING PAGE (AGENT)
    // TODO: BEFORE YOU CONTINUE (AGENT)
    // TODO: COMPLETE THE REST OF THE JOURNEY
  }
}
