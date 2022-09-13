package com.zigzag.crm.helper

import com.zigzag.crm.document.CrmUserDocument
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CrmUserRepositoryHelper: ReactiveMongoRepository<CrmUserDocument, String> {

}
