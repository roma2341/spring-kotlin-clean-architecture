package com.zigzag.crm.framework.mongo.repository.contact

import com.zigzag.crm.framework.domain.api.features.contact.CrmContact
import io.mcarle.konvert.api.Konverter
import io.mcarle.konvert.injector.spring.KComponent

@Konverter
@KComponent
interface CrmContactDocumentMapper {
    fun convertDocumentToEntity(document: CrmContactDocument): CrmContact
    fun convertEntityToDocument(entity: CrmContact): CrmContactDocument
}
