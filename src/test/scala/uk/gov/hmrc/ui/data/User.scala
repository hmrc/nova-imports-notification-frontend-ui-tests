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

final case class User(
  title: String,
  firstName: String,
  lastName: String,
  phoneNumber: Option[String],
  mobileNumber: Option[String],
  email: String
)

object User {
  val User1: User = User(
    title = "Mr",
    firstName = "John",
    lastName = "Smith",
    phoneNumber = None,
    mobileNumber = Some("07700 900999"),
    email = "john.smith@example.com"
  )

  val User2: User = User(
    title = "Mrs",
    firstName = "Jane",
    lastName = "Smith",
    phoneNumber = Some("0191 498 0000"),
    mobileNumber = None,
    email = "jane.smith1988@example.co.uk"
  )
}
