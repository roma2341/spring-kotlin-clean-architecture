package com.zigzag.crm.usecase.lead.mapper

import com.zigzag.crm.framework.domain.api.features.lead.Lead
import com.zigzag.crm.usecase.lead.dto.LeadDto
import io.mcarle.konvert.api.Konverter
import io.mcarle.konvert.injector.spring.KComponent

@Konverter
@KComponent
interface LeadMapper {
    fun convertDtoToEntity(leadDto: LeadDto.Request.Create): Lead
    fun convertDtoToEntity(leadDto: LeadDto.Request.Search): Lead
    fun convertEntityToDto(lead: Lead): LeadDto.Response.Public
}

