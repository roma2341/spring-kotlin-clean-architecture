package com.zigzag.crm.framework.domain.api.features.lead

import com.zigzag.crm.framework.domain.api.features.lead.enums.LeadFunnelStatus
import com.zigzag.crm.framework.domain.api.features.user.CrmUser

data class Lead(
    var id: String? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var email: String? = null,
    var leadFunnelStatus: LeadFunnelStatus? = null,
    var agentId: String? = null
)
