package com.zigzag.crm.usecase.feature.lead.dto

data class AssignLeadToAgentRequest(
    var leadId: String,
    var agentId: String
)
