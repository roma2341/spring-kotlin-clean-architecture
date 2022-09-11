package com.zigzag.crm.repository.api

import com.zigzag.crm.framework.domain.api.features.user.CrmUser
import org.springframework.stereotype.Component


interface ICrmUserRepository {
    fun createUser(user: CrmUser): CrmUser;
    fun findById(id: Long): CrmUser?;
}
