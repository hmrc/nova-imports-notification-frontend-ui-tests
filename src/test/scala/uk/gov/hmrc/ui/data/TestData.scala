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

object TestData {
  val manualUkAddress: Address = Address(
    line1 = "",
    line2 = "",
    line3 = None,
    line4 = None,
    postcode = None,
    country = Some("GB")
  )

  object UkUser {
    val user: User = User(
      title = "Mr",
      firstName = "John",
      lastName = "Smith",
      address = manualUkAddress,
      landline = None,
      telephone = Some("07700 900999"),
      email = "john.smith@example.com"
    )
  }
}
