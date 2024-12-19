package com.zigzag.crm.framework.domain.api.features.user

import com.zigzag.crm.domain.api.features.user.enums.CrmUserStatus
import java.time.Instant

data class Notification(
    val id: String? = null,
    var firstName: String?= null,
    var lastName: String?= null,
    var email: String?= null,
    var deletedAt: Instant? = null,
    var status: CrmUserStatus
)