package com.zigzag.crm.usecase.lead.mapper

import com.zigzag.crm.framework.domain.api.features.lead.Lead
import com.zigzag.crm.usecase.lead.dto.LeadDto
import org.springframework.stereotype.Component

@Component
class LeadMapperImpl : LeadMapper {
    override fun convertDtoToEntity(leadDto: LeadDto.Request.Create): Lead {
        return Lead(
            firstName = leadDto.firstName,
            lastName = leadDto.lastName,
            email = leadDto.email
        )
    }
    override fun convertEntityToDto(lead: Lead): LeadDto.Response.Public {
        return LeadDto.Response.Public(
            firstName = lead.firstName,
            lastName = lead.lastName,
            email = lead.email,
            leadStep = lead.leadStep,
            id = lead.id
        )
    }
}