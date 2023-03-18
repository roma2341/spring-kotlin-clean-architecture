package com.zigzag.crm.repository.user

import com.zigzag.crm.repository.user.CrmUserDocument
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CrmUserRepositoryHelper: ReactiveMongoRepository<CrmUserDocument, String> {

}
