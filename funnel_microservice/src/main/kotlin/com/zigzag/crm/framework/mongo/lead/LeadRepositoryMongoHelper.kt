package com.zigzag.crm.framework.mongo.lead

import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface LeadRepositoryMongoHelper: ReactiveMongoRepository<LeadDocument, String> {
    fun findBy(pageable: Pageable): Flux<LeadDocument>
}
