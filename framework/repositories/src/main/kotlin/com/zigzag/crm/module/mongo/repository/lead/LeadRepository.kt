package com.zigzag.crm.module.mongo.repository.lead

import com.zigzag.crm.framework.domain.api.features.lead.ILeadRepository
import com.zigzag.crm.framework.domain.api.features.lead.Lead
import org.springframework.data.domain.Example
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.lang.RuntimeException

@Component
class LeadRepository(private val leadRepositoryMongoHelper: LeadRepositoryMongoHelper,
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

    override fun findAll(): Flux<Lead> {
        return leadRepositoryMongoHelper.findAll().map { u -> leadDocumentMapper.convertDocumentToEntity(u)}
    }

    override fun find(lead: Lead): Flux<Lead> {
        var document = leadDocumentMapper.convertEntityToDocument(lead);
        return leadRepositoryMongoHelper.findAll(Example.of(document)).map{ doc -> leadDocumentMapper.convertDocumentToEntity(doc)};
    };

}
