package uk.gov.hmrc.ui.helpers

enum AffinityGroup:
  case Individual, Organisation, Agent, OrganisationVRN, OrganisationVAT, AgentVAT, AgentVRN

  def getAffinityGroup: String = this match {
    case Organisation    => "Organisation"
    case Individual      => "Individual"
    case Agent           => "Agent"
    case OrganisationVRN => "Organisation"
    case OrganisationVAT => "Organisation"
    case AgentVAT        => "Agent"
    case AgentVRN        => "Agent"
  }

  def getEnrolmentKey: String = this match {
    case Organisation    => ""
    case Individual      => ""
    case Agent           => ""
    case OrganisationVRN => "HMRC-MTD-VAT"
    case OrganisationVAT => "HMCE-VATDEC-ORG"
    case AgentVAT        => "HMCE-VAT-AGNT"
    case AgentVRN        => "HMRC-NOVRN-AGNT"
  }

  def getIdentifierName: String = this match {
    case Organisation    => ""
    case Individual      => ""
    case Agent           => ""
    case OrganisationVRN => "VRN"
    case OrganisationVAT => "VATRegNo"
    case AgentVAT        => "AgentRefNo"
    case AgentVRN        => "VATAgentRefNo"
  }

  def getIdentifierValue: String = this match {
    case Organisation    => ""
    case Individual      => ""
    case Agent           => ""
    case OrganisationVRN => RandomIdGenerator.generateRandomIdentifierValue()
    case OrganisationVAT => RandomIdGenerator.generateRandomIdentifierValue()
    case AgentVAT        => "DVA0001"
    case AgentVRN        => "DVLA002"
  }
