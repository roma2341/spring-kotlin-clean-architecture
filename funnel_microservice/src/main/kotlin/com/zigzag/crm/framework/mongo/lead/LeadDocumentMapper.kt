package com.zigzag.crm.framework.mongo.lead

import com.zigzag.crm.framework.domain.api.features.lead.Lead
import io.mcarle.konvert.api.Konverter
import io.mcarle.konvert.injector.spring.KComponent


@Konverter
@KComponent
interface LeadDocumentMapper {
    fun convertDocumentToEntity(document: LeadDocument): Lead
    fun convertEntityToDocument(lead: Lead): LeadDocument
}
