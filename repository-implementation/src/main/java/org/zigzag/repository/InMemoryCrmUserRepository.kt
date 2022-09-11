package org.zigzag.repository

import com.zigzag.crm.framework.domain.api.features.user.CrmUser
import org.springframework.stereotype.Component
import org.zigzag.repository.api.ICrmUserRepository

@Component
class InMemoryCrmUserRepository : ICrmUserRepository {
    var nextId: Long = 0;
    var datasource = mutableMapOf<Long, CrmUser>();

    override fun createUser(user: CrmUser): CrmUser {
        val persistedUser = user.copy(id = nextId++);
        datasource.put(user.id,persistedUser);
        return persistedUser;
    };

}
