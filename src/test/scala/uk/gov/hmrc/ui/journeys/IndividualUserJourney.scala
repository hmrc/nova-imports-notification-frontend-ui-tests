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

import uk.gov.hmrc.ui.helpers.{AffinityGroup, CYAPage}
import uk.gov.hmrc.ui.pages.common.{AreYouABusinessOrPrivateIndividual, AreYouNotifyingAsPurchaserOrOnBehalf, CheckYourAnswers, PurchaserOnBehalfOfABusinessOrIndividual, VehicleBroughtIntoNIFromOutsideEUPage}

object IndividualUserJourney {
  // Acquisition flow
  object Acquisition {
    def notifyingAsAPrivateIndividualAsANotifier(): Unit = {
      CommonJourney.loginAndStartANotification(AffinityGroup.Individual)
      CommonJourney.beginAnAcquisition()
      CommonJourney.notifierIsAPrivateIndividual()
      CommonJourney.selfNotifying()
      CommonJourney.validateCheckYourAnswers(CYAPage.InitialQuestions, AffinityGroup.Individual)
      // TODO: TASK LIST
      CommonJourney.addUserDetailsNamePhoneNumberEmailAddress()
      CheckYourAnswers(CYAPage.YourDetails).clickContinue()
      // TODO: SHOULD BE AT TASK LIST AGAIN
      CommonJourney.notifierHasUkDetails()
      // TODO: SHOULD BE AT TASK LIST AGAIN
    }

    def notifyingAsABusinessAsANotifier(): Unit = {
      CommonJourney.loginAndStartANotification(AffinityGroup.Individual)
      CommonJourney.beginAnAcquisition()
      CommonJourney.notifierIsABusiness()
      CommonJourney.selfNotifying()
      CommonJourney.validateCheckYourAnswers(CYAPage.InitialQuestions, AffinityGroup.Individual)
      // TODO: TASK LIST
      // TODO: BUSINESS NAME PAGE
      // TODO: CYA2.0 AND ADDRESS STUFF
    }

    def notifyingAsAIndividualOnBehalfOfBusiness(): Unit = {
      CommonJourney.loginAndStartANotification(AffinityGroup.Individual)
      CommonJourney.beginAnAcquisition()
      CommonJourney.notifierIsAPrivateIndividual()
      CommonJourney.notifyingForABusiness()
      CommonJourney.validateCheckYourAnswers(CYAPage.InitialQuestions, AffinityGroup.Individual)
      // TODO: TASK LIST
      CommonJourney.addUserDetailsNamePhoneNumberEmailAddress()
      CheckYourAnswers(CYAPage.YourDetails).clickContinue()
      // TODO: SHOULD BE AT TASK LIST AGAIN
      CommonJourney.notifierHasUkDetails()
      // TODO: SHOULD BE AT TASK LIST AGAIN
    }

    def notifyingAsAIndividualOnBehalfOfIndividual(): Unit = {
      CommonJourney.loginAndStartANotification(AffinityGroup.Individual)
      CommonJourney.beginAnAcquisition()
      CommonJourney.notifierIsAPrivateIndividual()
      CommonJourney.notifyingForAnIndividual()
      CommonJourney.validateCheckYourAnswers(CYAPage.InitialQuestions, AffinityGroup.Individual)
      // TODO: TASK LIST
      CommonJourney.addUserDetailsNamePhoneNumberEmailAddress()
      CheckYourAnswers(CYAPage.YourDetails).clickContinue()
      // TODO: TASK LIST
      CommonJourney.notifierHasUkDetails()
      // TODO: SHOULD BE AT TASK LIST AGAIN
    }

    def notifyingAsABusinessOnBehalfOfABusiness(): Unit = {
      CommonJourney.loginAndStartANotification(AffinityGroup.Individual)
      CommonJourney.beginAnAcquisition()
      CommonJourney.notifierIsABusiness()
      CommonJourney.notifyingForABusiness()
      CommonJourney.validateCheckYourAnswers(CYAPage.InitialQuestions, AffinityGroup.Individual)
      // TODO: TASK LIST
      // TODO: BUSINESS NAME FOR NOTIFIER + SUPPLIER DETAILS + ADDRESS
    }

    def notifyingAsABusinessOnBehalfOfIndividual(): Unit = {
      CommonJourney.loginAndStartANotification(AffinityGroup.Individual)
      CommonJourney.beginAnAcquisition()
      CommonJourney.notifierIsABusiness()
      CommonJourney.notifyingForAnIndividual()
      CommonJourney.validateCheckYourAnswers(CYAPage.InitialQuestions, AffinityGroup.Individual)
      // TODO: TASK LIST
      // TODO: BUSINESS NAME FOR NOTIFIER + SUPPLIER NAME DETAILS + ADDRESS
    }
  }

  // Import flow
  object Import {
    def userNeedsToImportAVehicleFromOutsideEU(): Unit = {
      CommonJourney.loginAndStartANotification(AffinityGroup.Individual)
      CommonJourney.beginAnImport()
      VehicleBroughtIntoNIFromOutsideEUPage.verifyPageDisplayed()
    }
  }
}
