package com.zigzag.crm.usecase.lead.dto

data class AssignLeadToAgentRequest(
    var leadId: String,
    var agentId: String
)
