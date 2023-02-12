package com.zigzag.crm.framework.domain.api.repository

import com.zigzag.crm.framework.domain.api.features.user.CrmUser
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


interface ICrmUserRepository {
    fun createUser(user: CrmUser): Mono<CrmUser>;
    fun findById(id: String): Mono<CrmUser>;
    fun findAll(): Flux<CrmUser>;
}
