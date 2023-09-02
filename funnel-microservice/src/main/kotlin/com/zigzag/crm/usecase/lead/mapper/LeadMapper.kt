package com.zigzag.crm.usecase.lead.mapper

import com.zigzag.crm.framework.domain.api.features.lead.Lead
import com.zigzag.crm.usecase.lead.dto.LeadDto
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface LeadMapper {
    fun convertDtoToEntity(leadDto: LeadDto.Request.Create): Lead
    fun convertDtoToEntity(leadDto: LeadDto.Request.Search): Lead
    fun convertEntityToDto(lead: Lead): LeadDto.Response.Public
}
