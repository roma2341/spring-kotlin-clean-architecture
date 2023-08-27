package com.zigzag.crm.framework.mongo.repository.contact

import com.zigzag.crm.module.mongo.repository.user.CrmUserDocument
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CrmContactRepositoryMongoHelper : ReactiveMongoRepository<CrmContactDocument, String> {
}
