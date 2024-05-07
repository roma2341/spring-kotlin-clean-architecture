package com.zigzag.crm.framework.dao.lead.mongo

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepositoryMongoHelper: ReactiveMongoRepository<ProductMongoDocument, String> {

}
