package com.zigzag.crm.repository

import com.zigzag.crm.document.CrmUserDocument
import com.zigzag.crm.framework.domain.api.features.user.CrmUser
import com.zigzag.crm.framework.domain.api.repository.ICrmUserRepository
import com.zigzag.crm.helper.CrmUserRepositoryHelper
import com.zigzag.crm.mapper.CrmUserDocumentMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class MongoCrmUserRepository(private val crmUserRepositoryHelper: CrmUserRepositoryHelper,
                             private val crmUserDocumentMapper: CrmUserDocumentMapper) : ICrmUserRepository {

    override fun createUser(user: CrmUser): Mono<CrmUser> {
        val document = crmUserDocumentMapper.convertUserToDocument(user);
        return crmUserRepositoryHelper.save(document).map { u -> crmUserDocumentMapper.convertDocumentToUser(u); }
    }

    override fun findById(id: String): Mono<CrmUser> {
        return crmUserRepositoryHelper.findById(id).map { u -> crmUserDocumentMapper.convertDocumentToUser(u) }
    }

    override fun findAll(): Flux<CrmUser> {
        return crmUserRepositoryHelper.findAll().map {u -> crmUserDocumentMapper.convertDocumentToUser(u)}
    };

}
