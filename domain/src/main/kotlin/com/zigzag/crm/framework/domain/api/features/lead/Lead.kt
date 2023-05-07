package com.zigzag.crm.framework.domain.api.features.lead

import com.zigzag.crm.framework.domain.api.features.lead.enums.LeadFunnelStatus

data class Lead(
    val id: String? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val email: String? = null,
    val leadFunnelStatus: LeadFunnelStatus? = null
)
