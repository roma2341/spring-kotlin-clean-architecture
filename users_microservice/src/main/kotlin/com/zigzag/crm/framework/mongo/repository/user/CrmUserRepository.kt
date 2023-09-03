package com.zigzag.crm.framework.mongo.repository.user

import com.zigzag.crm.framework.domain.api.features.user.CrmUser
import com.zigzag.crm.framework.domain.api.features.user.ICrmUserRepository
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class CrmUserRepository(private val crmUserRepositoryMongoHelper: CrmUserRepositoryMongoHelper,
                        private val crmUserDocumentMapper: CrmUserDocumentMapper
) : ICrmUserRepository {

    override fun createUser(user: CrmUser): Mono<CrmUser> {
        val document = crmUserDocumentMapper.convertUserToDocument(user);
        return crmUserRepositoryMongoHelper.save(document).map { u -> crmUserDocumentMapper.convertDocumentToUser(u); }
    }

    override fun findById(id: String): Mono<CrmUser> {
        return crmUserRepositoryMongoHelper.findById(id).map { u -> crmUserDocumentMapper.convertDocumentToUser(u) }
    }

    override fun findAll(): Flux<CrmUser> {
        return crmUserRepositoryMongoHelper.findAll().map { u -> crmUserDocumentMapper.convertDocumentToUser(u)}
    }

    override fun findFirst(): Mono<CrmUser> {
        return crmUserRepositoryMongoHelper.findSome().map { u -> crmUserDocumentMapper.convertDocumentToUser(u)}
    };

}
