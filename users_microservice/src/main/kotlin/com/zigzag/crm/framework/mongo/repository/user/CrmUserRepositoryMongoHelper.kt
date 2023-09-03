package com.zigzag.crm.framework.mongo.repository.user

import org.springframework.data.mongodb.repository.Aggregation
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface CrmUserRepositoryMongoHelper: ReactiveMongoRepository<CrmUserDocument, String> {

     @Query(sort = "{_id : 1}")
     @Aggregation(pipeline = [ "{ '\$limit' : 1 }" ])
     fun findSome(): Mono<CrmUserDocument>;
}
