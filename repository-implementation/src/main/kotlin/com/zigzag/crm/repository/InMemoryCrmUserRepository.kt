package com.zigzag.crm.repository

import com.zigzag.crm.framework.domain.api.features.user.CrmUser
import com.zigzag.crm.repository.api.ICrmUserRepository
import org.springframework.stereotype.Component


@Component
class InMemoryCrmUserRepository : ICrmUserRepository {
    var nextId: Long = 0;
    var datasource = mutableMapOf<Long, CrmUser>();

    override fun createUser(user: CrmUser): CrmUser {
        val persistedUser = user.copy(id = nextId++);
        datasource.put(user.id,persistedUser);
        return persistedUser;
    }

    override fun findById(id: Long): CrmUser? {
        return datasource.get(id);
    };

}
