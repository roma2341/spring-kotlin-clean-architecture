package com.zigzag.crm.module.mongo.repository.contact

import com.zigzag.crm.framework.domain.api.features.contact.CrmContact
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface CrmContactDocumentMapper {
    fun convertDocumentToEntity(document: CrmContactDocument): CrmContact
    fun convertEntityToDocument(entity: CrmContact): CrmContactDocument
}
