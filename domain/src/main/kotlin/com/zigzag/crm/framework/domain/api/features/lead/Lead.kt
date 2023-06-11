package com.zigzag.crm.framework.domain.api.features.lead

import com.zigzag.crm.framework.domain.api.features.common.Ownable
import com.zigzag.crm.framework.domain.api.features.lead.enums.LeadFunnelStatus

data class Lead(
    var id: String? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var email: String? = null,
    var leadFunnelStatus: LeadFunnelStatus? = null,
    var agentId: String? = null,
    override var ownerId: String? = null
): Ownable<String>
