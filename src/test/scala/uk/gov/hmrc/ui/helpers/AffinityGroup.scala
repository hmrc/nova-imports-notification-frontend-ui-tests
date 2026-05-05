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

enum AffinityGroup:
  case Individual, Organisation, Agent, OrganisationVRN, OrganisationVAT, AgentVAT, AgentVRN1, AgentVRN2

  def getAffinityGroup: String = this match {
    case Organisation    => "Organisation"
    case Individual      => "Individual"
    case Agent           => "Agent"
    case OrganisationVRN => "Organisation"
    case OrganisationVAT => "Organisation"
    case AgentVAT        => "Agent"
    case AgentVRN1       => "Agent"
    case AgentVRN2       => "Agent"
  }

  def getEnrolmentKey: String = this match {
    case Organisation    => ""
    case Individual      => ""
    case Agent           => ""
    case OrganisationVRN => "HMRC-MTD-VAT"
    case OrganisationVAT => "HMCE-VATDEC-ORG"
    case AgentVAT        => "HMCE-VAT-AGNT"
    case AgentVRN1       => "HMRC-NOVRN-AGNT"
    case AgentVRN2       => "HMRC-NOVRN-AGNT"
  }

  def getIdentifierName: String = this match {
    case Organisation    => ""
    case Individual      => ""
    case Agent           => ""
    case OrganisationVRN => "VRN"
    case OrganisationVAT => "VATRegNo"
    case AgentVAT        => "AgentRefNo"
    case AgentVRN1       => "VATAgentRefNo"
    case AgentVRN2       => "VATAgentRefNo"
  }

  def getIdentifierValue: String = this match {
    case Organisation    => ""
    case Individual      => ""
    case Agent           => ""
    case OrganisationVRN => RandomIdGenerator.generateRandomIdentifierValue()
    case OrganisationVAT => RandomIdGenerator.generateRandomIdentifierValue()
    case AgentVAT        => RandomIdGenerator.generateRandomIdentifierValue()
    case AgentVRN1       => "DVA0001"
    case AgentVRN2       => "DVLA002"
  }
