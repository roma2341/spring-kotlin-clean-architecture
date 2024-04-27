package com.zigzag.crm.framework.mongo.lead

import com.zigzag.crm.framework.domain.api.features.lead.Lead

abstract class LeadDocumentMapper {
    companion object {
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
}
