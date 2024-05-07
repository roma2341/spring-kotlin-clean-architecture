package com.zigzag.crm.framework.mongo.lead

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepositoryMongoHelper: ReactiveMongoRepository<ProductDocument, String> {

}
