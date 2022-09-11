package org.zigzag.repository.api

import com.zigzag.crm.framework.domain.api.features.user.CrmUser
import org.springframework.stereotype.Component


@Component
interface ICrmUserRepository {
    fun createUser(user: CrmUser): CrmUser;
}
