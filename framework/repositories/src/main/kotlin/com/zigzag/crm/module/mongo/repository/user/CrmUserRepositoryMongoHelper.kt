package com.zigzag.crm.module.mongo.repository.user

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface CrmUserRepositoryMongoHelper: ReactiveMongoRepository<CrmUserDocument, String> {
     fun findFirst(): Mono<CrmUserDocument>;
}
