package com.zigzag.crm.framework.mongo.repository.contact

import com.zigzag.crm.framework.domain.api.features.contact.CrmContact
import com.zigzag.crm.framework.domain.api.features.contact.ICrmContactRepository
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class CrmContactRepository(private val crmContactRepositoryMongoHelper: CrmContactRepositoryMongoHelper,
                           private val crmContactDocumentMapper: CrmContactDocumentMapper
) :
    ICrmContactRepository {
    override fun createContact(contact: CrmContact): Mono<CrmContact> {
        val document = crmContactDocumentMapper.convertEntityToDocument(contact);
        var documentMono = crmContactRepositoryMongoHelper.save(document);
        return documentMono.map { d -> crmContactDocumentMapper.convertDocumentToEntity(d) }
    }
}
