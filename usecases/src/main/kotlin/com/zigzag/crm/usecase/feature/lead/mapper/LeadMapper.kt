package com.zigzag.crm.usecase.feature.lead.mapper

import com.zigzag.crm.framework.domain.api.features.lead.Lead
import com.zigzag.crm.usecase.feature.lead.dto.LeadDto
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface LeadMapper {
    fun convertDtoToEntity(leadDto: LeadDto.Request.Create): Lead
    fun convertEntityToDto(lead: Lead): LeadDto.Response.Public
}

