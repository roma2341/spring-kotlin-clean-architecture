package com.zigzag.crm.framework.mongo.lead.mapper

import com.zigzag.crm.framework.domain.api.features.lead.Lead
import com.zigzag.crm.framework.mongo.lead.LeadDocument

interface LeadDocumentMapper {
        fun convertDocumentToEntity(document: LeadDocument): Lead
        fun convertEntityToDocument(lead: Lead): LeadDocument
}
