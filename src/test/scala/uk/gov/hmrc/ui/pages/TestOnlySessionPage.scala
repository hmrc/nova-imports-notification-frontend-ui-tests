/*
 * Copyright 2023 HM Revenue & Customs
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

package uk.gov.hmrc.ui.pages

import org.openqa.selenium.By

object TestOnlySessionPage extends BasePage {

  override val pageUrl: String = s"$baseUrl/test-only/session"

  object PageLocators {
    val sessionDataTextArea: By = By.id("sessionData")

    val saveButton: By = By.xpath("//button[normalize-space()='Save']")
  }

  val selectedClientJson: String =
    """{
      |  "agentSelectedClient": {
      |    "vrn": "123456789",
      |    "name": "Test Client Ltd"
      |    }
      |}
  """.stripMargin

  def setSelectedClientInSession(): Unit = {
    goToPage(pageUrl)

    val sessionDataTextArea = waitForVisibilityOfElement(PageLocators.sessionDataTextArea)
    sessionDataTextArea.clear()
    sessionDataTextArea.sendKeys(selectedClientJson)

    click(PageLocators.saveButton)
    verifyPageUrl()
  }
}
