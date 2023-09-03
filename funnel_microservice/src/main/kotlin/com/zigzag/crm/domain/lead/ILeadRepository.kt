package com.zigzag.crm.framework.domain.api.features.lead

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


interface ILeadRepository {

    fun updateLead(user: Lead): Mono<Lead>;
    fun createLead(user: Lead): Mono<Lead>;
    fun findById(id: String): Mono<Lead>;
    fun findAll(): Flux<Lead>;
    fun find(lead: Lead): Flux<Lead>
}
