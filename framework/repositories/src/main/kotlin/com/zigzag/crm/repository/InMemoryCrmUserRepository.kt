package com.zigzag.crm.repository

import com.zigzag.crm.framework.domain.api.features.user.CrmUser
import com.zigzag.crm.framework.domain.api.repository.ICrmUserRepository
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono


@Component
@ConditionalOnExpression
class InMemoryCrmUserRepository : ICrmUserRepository {
    var nextId: Long = 0;
    var datasource = mutableMapOf<Long, CrmUser>();

    override fun createUser(user: CrmUser): Mono<CrmUser> {
        val persistedUser = user.copy(id = nextId++);
        datasource.put(user.id,persistedUser);
        return Mono.just(persistedUser);
    }

    override fun findById(id: Long): Mono<CrmUser> {
        return Mono.justOrEmpty(datasource.get(id));
    };

}
