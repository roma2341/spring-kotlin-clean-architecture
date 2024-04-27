package com.zigzag.crm.framework.mongo.lead.mapper

import com.zigzag.crm.framework.domain.api.features.lead.Lead
import com.zigzag.crm.framework.mongo.lead.LeadDocument
import org.springframework.stereotype.Component

@Component
class LeadDocumentMapperImpl {
        fun convertDocumentToEntity(document: LeadDocument): Lead {
            return Lead(
                id = document.id,
                firstName = document.firstName,
                lastName = document.lastName,
                email = document.email
            )
        }

        fun convertEntityToDocument(lead: Lead): LeadDocument {
            return LeadDocument(
                id = lead.id,
                firstName = lead.firstName,
                lastName = lead.lastName,
                email = lead.email
            )
        }
}
