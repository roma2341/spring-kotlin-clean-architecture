package com.zigzag.crm.framework.domain.api.features.lead

import com.zigzag.crm.domain.lead.enums.LeadAssignementStatus
import com.zigzag.crm.framework.domain.api.features.lead.enums.LeadStep
import org.zigzag.crm.common.Ownable

data class Lead(
    var id: String? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var email: String? = null,
    var leadStep: LeadStep? = null,
    var assignmentStatus: LeadAssignementStatus? = null,
    var agentId: String? = null,
    override var ownerId: String? = null
): Ownable<String>
