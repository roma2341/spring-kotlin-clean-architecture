package com.zigzag.crm.framework.domain.api.features.contact

import com.zigzag.crm.framework.domain.api.features.common.Ownable

data class CrmContact(
    val id: String?,
    val firstName: String?,
    val lastName: String?,
    val email: String?,
    val phone: String?,
    override var ownerId: String?
) : Ownable<String>
