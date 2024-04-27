package com.zigzag.crm.framework.mongo.repository.contact.mapper

import com.zigzag.crm.framework.domain.api.features.contact.CrmContact
import com.zigzag.crm.framework.mongo.repository.contact.CrmContactDocument

interface CrmContactDocumentMapper {
     fun convertDocumentToEntity(document: CrmContactDocument): CrmContact
     fun convertEntityToDocument(entity: CrmContact): CrmContactDocument
}
