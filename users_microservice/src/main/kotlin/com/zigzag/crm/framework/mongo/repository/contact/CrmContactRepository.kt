package com.zigzag.crm.framework.mongo.repository.contact

import com.zigzag.crm.framework.domain.api.features.contact.CrmContact
import com.zigzag.crm.framework.domain.api.features.contact.ICrmContactRepository
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class CrmContactRepository(private val crmContactRepositoryMongoHelper: CrmContactRepositoryMongoHelper
) :
    ICrmContactRepository {
    override fun createContact(contact: CrmContact): Mono<CrmContact> {
        val document = CrmContactDocumentMapper.convertEntityToDocument(contact);
        var documentMono = crmContactRepositoryMongoHelper.save(document);
        return documentMono.map { d -> CrmContactDocumentMapper.convertDocumentToEntity(d) }
    }
}
