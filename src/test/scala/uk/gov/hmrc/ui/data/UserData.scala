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
//package uk.gov.hmrc.ui.data
//
//import uk.gov.hmrc.ui.helpers.RandomValueGenerator
//import uk.gov.hmrc.ui.models.UserDetails.{BusinessDetails, IndividualDetails}
//import uk.gov.hmrc.ui.models.{Notifier, Supplier, UserDetails}
//
//object UserData {
//  object NotifierDetails {
//    val notifierIndividual = Notifier.NotifierDetails(
//      userDetails = IndividualDetails(
//        title = RandomValueGenerator.getRandomTitle(),
//        firstName = RandomValueGenerator.generateRandomFirstName(),
//        lastName = RandomValueGenerator.generateRandomLastName()
//      ),
//      phoneNumber = None,
//      mobileNumber = Some(RandomValueGenerator.generateRandomUkMobileNumber()),
//      email = RandomValueGenerator.generateRandomUserEmail()
//    )
//
//    val notifierBusiness = Notifier.NotifierDetails(
//      userDetails = BusinessDetails(
//        businessName = RandomValueGenerator.generateBusinessName()
//      ),
//      phoneNumber = Some(RandomValueGenerator.generateRandomUkLandlineNumber()),
//      mobileNumber = Some(RandomValueGenerator.generateRandomUkBusinessNumber()),
//      email = RandomValueGenerator.generateRandomBusinessEmail()
//    )
//  }
//
//  object PurchaserDetails {
//    val purchaserIsBusiness = UserDetails.BusinessDetails(
//      businessName = RandomValueGenerator.generateBusinessName()
//    )
//
//    val purchaserIsIndividual = UserDetails.IndividualDetails(
//      title = RandomValueGenerator.getRandomTitle(),
//      firstName = RandomValueGenerator.generateRandomFirstName(),
//      lastName = RandomValueGenerator.generateRandomLastName()
//    )
//  }
//
//  object SupplierDetails {
//    val supplierIsBusiness = UserDetails.BusinessDetails(
//      businessName = RandomValueGenerator.generateBusinessName()
//    )
//
//    val supplierIsIndividual = UserDetails.IndividualDetails(
//      title = RandomValueGenerator.getRandomTitle(),
//      firstName = RandomValueGenerator.generateRandomFirstName(),
//      lastName = RandomValueGenerator.generateRandomLastName()
//    )
//  }
//}