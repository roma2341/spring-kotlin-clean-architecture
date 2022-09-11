package com.zigzag.crm.repository.api

import com.zigzag.crm.framework.domain.api.features.user.CrmUser
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono


interface ICrmUserRepository {
    fun createUser(user: CrmUser): Mono<CrmUser>;
    fun findById(id: Long): Mono<CrmUser>;
}
