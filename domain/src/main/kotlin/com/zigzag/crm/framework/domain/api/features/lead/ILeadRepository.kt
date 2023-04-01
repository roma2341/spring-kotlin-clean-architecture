package com.zigzag.crm.framework.domain.api.features.lead

import com.zigzag.crm.framework.domain.api.features.user.CrmUser
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


interface ILeadRepository {
    fun createUser(user: Lead): Mono<Lead>;
    fun findById(id: String): Mono<Lead>;
    fun findAll(): Flux<Lead>;
}
