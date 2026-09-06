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

import uk.gov.hmrc.ui.helpers.{AffinityGroup, CYAPage, NotificationType}
import uk.gov.hmrc.ui.pages.common.{CheckYourAnswers, NotificationTaskList}

object VATOrganisationUserJourney {
  object Acquisition {
    def bringingAVehicleInForBusinessUse(): Unit = {
      CommonJourney.loginAndStartANotification(AffinityGroup.OrganisationVAT, NotificationType.Acquisition)
      CommonJourney.vehicleBroughtInForBusinessUse(AffinityGroup.OrganisationVAT)
      CommonJourney.validateCheckYourAnswers(CYAPage.InitialQuestions, AffinityGroup.OrganisationVAT)
      NotificationTaskList.verifyTaskListWithoutAddress()
      CommonJourney.addYourDetails()
      CommonJourney.validateAddYourDetailsGuidancePage()
      CommonJourney.addPhoneAndEmailDetails()
      CheckYourAnswers(CYAPage.YourDetails).clickContinue()
      NotificationTaskList.verifyAddYourDetailsStatus("Completed")
      CommonJourney.addVehicleDetails()
    }

    def bringingAVehicleInForPrivateUse(): Unit = {
      CommonJourney.loginAndStartANotification(AffinityGroup.OrganisationVAT, NotificationType.Acquisition)
      CommonJourney.vehicleBroughtInForPersonalUse(AffinityGroup.OrganisationVAT)
      CommonJourney.validateCheckYourAnswers(CYAPage.InitialQuestions, AffinityGroup.OrganisationVAT)
      NotificationTaskList.verifyTaskListWithAddress()
      CommonJourney.addYourDetails()
      CommonJourney.validateAddYourDetailsGuidancePage()
      CommonJourney.addUserDetailsNamePhoneNumberEmailAddress()
      CheckYourAnswers(CYAPage.YourDetails).clickContinue()
      NotificationTaskList.verifyAddYourDetailsStatus("Completed")
      CommonJourney.addYourAddress()
      CommonJourney.notifierHasUkDetails()
      NotificationTaskList.verifyAddYourAddressStatus("Completed")
      CommonJourney.addVehicleDetails()
    }
  }

  object Import {
    def importAVehicleForBusinessUse(): Unit = {
      CommonJourney.loginAndStartANotification(AffinityGroup.OrganisationVAT, NotificationType.Acquisition)
      CommonJourney.vehicleBroughtInForBusinessUse(AffinityGroup.OrganisationVAT)
      CommonJourney.validateCheckYourAnswers(CYAPage.InitialQuestions, AffinityGroup.OrganisationVAT)
      NotificationTaskList.verifyTaskListWithoutAddress()
      CommonJourney.addYourDetails()
      CommonJourney.validateAddYourDetailsGuidancePage()
      CommonJourney.addPhoneAndEmailDetails()
      CheckYourAnswers(CYAPage.YourDetails).clickContinue()
      NotificationTaskList.verifyAddYourDetailsStatus("Completed")
    }

    def importAVehicleForPrivateUse(): Unit = {
      CommonJourney.loginAndStartANotification(AffinityGroup.OrganisationVAT, NotificationType.Acquisition)
      CommonJourney.vehicleBroughtInForPersonalUse(AffinityGroup.OrganisationVAT)
      CommonJourney.validateCheckYourAnswers(CYAPage.InitialQuestions, AffinityGroup.OrganisationVAT)
      NotificationTaskList.verifyTaskListWithAddress()
      CommonJourney.addYourDetails()
      CommonJourney.validateAddYourDetailsGuidancePage()
      CommonJourney.addUserDetailsNamePhoneNumberEmailAddress()
      CheckYourAnswers(CYAPage.YourDetails).clickContinue()
      NotificationTaskList.verifyAddYourDetailsStatus("Completed")
      CommonJourney.addYourAddress()
      CommonJourney.notifierHasUkDetails()
      NotificationTaskList.verifyAddYourAddressStatus("Completed")
    }
  }
}
