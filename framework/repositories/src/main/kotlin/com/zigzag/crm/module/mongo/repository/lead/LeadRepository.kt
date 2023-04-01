package com.zigzag.crm.module.mongo.repository.lead

import com.zigzag.crm.framework.domain.api.features.lead.ILeadRepository
import com.zigzag.crm.framework.domain.api.features.lead.Lead
import com.zigzag.crm.framework.domain.api.features.user.CrmUser
import com.zigzag.crm.framework.domain.api.features.user.ICrmUserRepository
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class LeadRepository(private val leadRepositoryMongoHelper: LeadRepositoryMongoHelper,
                     private val leadDocumentMapper: LeadDocumentMapper
) : ILeadRepository {

    override fun createUser(lead: Lead): Mono<Lead> {
        val document = leadDocumentMapper.convertEntityToDocument(lead);
        return leadRepositoryMongoHelper.save(document).map { u -> leadDocumentMapper.convertDocumentToEntity(u); }
    }

    override fun findById(id: String): Mono<Lead> {
        return leadRepositoryMongoHelper.findById(id).map { u -> leadDocumentMapper.convertDocumentToEntity(u) }
    }

    override fun findAll(): Flux<Lead> {
        return leadRepositoryMongoHelper.findAll().map { u -> leadDocumentMapper.convertDocumentToEntity(u)}
    };

}
