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

package uk.gov.hmrc.ui.data

import uk.gov.hmrc.ui.models.UserDetails.{BusinessDetails, IndividualUserDetails}
import uk.gov.hmrc.ui.models.{Notifier, Supplier}

object TestData {
  object NotifierDetails {
    val notifier = Notifier.NotifierDetails(
      userDetails = IndividualUserDetails(
        title = "Mr",
        firstName = "John",
        lastName = "Smith"
      ),
      phoneNumber = None,
      mobileNumber = Some("07700 900999"),
      email = "john.smith@example.com"
    )
  }

  object SupplierDetails {
    val businessSupplier = Supplier.BusinessSupplier(
      userDetails = BusinessDetails(
        businessName = "Test Company Ltd"
      )
    )

    val individualSupplier = Supplier.IndividualSupplier(
      userDetails = IndividualUserDetails(
        title = "Mrs",
        firstName = "Jane",
        lastName = "Smith"
      )
    )
  }
}
