package com.zigzag.crm.framework.domain.api.features.lead

import com.zigzag.crm.framework.domain.api.features.lead.enums.LeadFunnelStatus

data class Lead(
    val id: String?,
    val firstName: String?,
    val lastName: String?,
    val email: String?,
    val leadFunnelStatus: LeadFunnelStatus?
)
