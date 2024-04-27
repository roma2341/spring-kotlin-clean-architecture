package com.zigzag.crm.framework.mongo.repository.contact.mapper

import com.zigzag.crm.framework.domain.api.features.contact.CrmContact
import com.zigzag.crm.framework.mongo.repository.contact.CrmContactDocument
import org.springframework.stereotype.Component

@Component
class CrmContactDocumentMapperImpl : CrmContactDocumentMapper {
    override fun convertDocumentToEntity(document: CrmContactDocument): CrmContact {
        return CrmContact(
            id = document.id,
            firstName = document.firstName,
            lastName = document.lastName,
            email = document.email,
            phone = document.phone,
            ownerId = null
        )
    }
    override fun convertEntityToDocument(entity: CrmContact): CrmContactDocument {
        return CrmContactDocument(
            entity.id,
            entity.firstName,
            entity.lastName,
            entity.email,
            entity.phone
        )
    }
}