package com.zigzag.crm.framework.mongo.lead

import com.zigzag.crm.framework.domain.api.features.lead.ILeadRepository
import com.zigzag.crm.framework.domain.api.features.lead.Lead
import com.zigzag.crm.framework.mongo.lead.mapper.LeadDocumentMapper
import org.springframework.data.domain.Example
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class LeadRepository(
    private val leadRepositoryMongoHelper: LeadRepositoryMongoHelper,
    private val leadDocumentMapper: LeadDocumentMapper
) : ILeadRepository {
    override fun updateLead(lead: Lead): Mono<Lead> {
        if(lead.id == null) {
            throw RuntimeException("Cannot update lead if empty id")
        }
        val document = leadDocumentMapper.convertEntityToDocument(lead);
        return leadRepositoryMongoHelper.save(document).map { u -> leadDocumentMapper.convertDocumentToEntity(u); };
    }

    override fun createLead(lead: Lead): Mono<Lead> {
        if(lead.id != null) {
            throw RuntimeException("Cannot create lead with non-empty id")
        }
        val document = leadDocumentMapper.convertEntityToDocument(lead);
        return leadRepositoryMongoHelper.save(document).map { u -> leadDocumentMapper.convertDocumentToEntity(u); }
    }

    override fun findById(id: String): Mono<Lead> {
        return leadRepositoryMongoHelper.findById(id).map { u -> leadDocumentMapper.convertDocumentToEntity(u) }
    }

    override fun findAll(pageable: Pageable): Flux<Lead> {
        return leadRepositoryMongoHelper.findBy(pageable).map { u -> leadDocumentMapper.convertDocumentToEntity(u)}
    }

    override fun count(): Mono<Long> {
        return leadRepositoryMongoHelper.count();
    }

}
