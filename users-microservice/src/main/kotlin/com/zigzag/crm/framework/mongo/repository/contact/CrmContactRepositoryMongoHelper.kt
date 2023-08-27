package com.zigzag.crm.framework.mongo.repository.contact

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CrmContactRepositoryMongoHelper : ReactiveMongoRepository<CrmContactDocument, String> {
}
