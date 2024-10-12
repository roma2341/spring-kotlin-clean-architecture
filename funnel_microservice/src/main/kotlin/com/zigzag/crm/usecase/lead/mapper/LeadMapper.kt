package com.zigzag.crm.usecase.lead.mapper

import com.zigzag.crm.framework.domain.api.features.lead.Lead
import com.zigzag.crm.usecase.lead.dto.LeadDto

interface  LeadMapper {
       fun convertDtoToEntity(leadDto: LeadDto.Request.Create): Lead
       fun convertEntityToDto(lead: Lead): LeadDto.Response.Public
}

