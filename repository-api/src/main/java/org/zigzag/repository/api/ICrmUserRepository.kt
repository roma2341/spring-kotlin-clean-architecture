package org.zigzag.repository.api

import com.zigzag.crm.framework.domain.features.user.CrmUser

interface ICrmUserRepository {
    fun createUser(user: CrmUser);
}
