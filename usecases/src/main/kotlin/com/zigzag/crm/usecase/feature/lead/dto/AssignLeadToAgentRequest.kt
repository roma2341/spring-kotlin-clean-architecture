package com.zigzag.crm.usecase.feature.lead.dto

data class AssignLeadToAgentRequest(
    val leadId: String,
    val agentId: String
)
