package com.zigzag.crm.framework.domain.api.features.user

import com.zigzag.crm.domain.api.features.user.enums.NotificationType
import java.time.Instant

data class Notification(
    val id: String? = null,
    var data: String? = null,
    var createdAt: Instant? = null,
    var updatedAt: Instant? = null,
    var status: NotificationType
)