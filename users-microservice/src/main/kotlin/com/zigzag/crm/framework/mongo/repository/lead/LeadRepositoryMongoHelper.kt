package com.zigzag.crm.framework.mongo.repository.lead

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface LeadRepositoryMongoHelper: ReactiveMongoRepository<LeadDocument, String> {

}
