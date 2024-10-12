package com.zigzag.crm.framework.domain.api.features.lead

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


interface ILeadRepository {

    fun updateLead(user: Lead): Mono<Lead>;
    fun createLead(user: Lead): Mono<Lead>;
    fun findById(id: String): Mono<Lead>;
    fun findAll(pageable: Pageable): Flux<Lead>;
    fun count():Mono<Long>
}
