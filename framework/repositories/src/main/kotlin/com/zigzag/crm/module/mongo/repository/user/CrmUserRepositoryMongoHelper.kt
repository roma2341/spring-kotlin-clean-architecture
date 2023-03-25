package com.zigzag.crm.module.mongo.repository.user

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CrmUserRepositoryMongoHelper: ReactiveMongoRepository<CrmUserDocument, String> {

}
