package com.zigzag.crm.module.mongo.repository.lead

import com.zigzag.crm.framework.domain.api.features.lead.Lead
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface LeadDocumentMapper {
    fun convertDocumentToEntity(document: LeadDocument): Lead
    fun convertEntityToDocument(lead: Lead): LeadDocument
}
