package com.zigzag.crm.usecase.lead.impl

import com.zigzag.crm.framework.domain.api.features.lead.ILeadRepository
import com.zigzag.crm.usecase.lead.api.Usecase_FindLeads
import com.zigzag.crm.usecase.lead.dto.LeadDto
import com.zigzag.crm.usecase.lead.mapper.LeadMapper
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
class Usecase_FindLeads_Impl(private val leadRepository: ILeadRepository
) : Usecase_FindLeads {
    override fun execute(leadDto: LeadDto.Request.Search): Flux<LeadDto.Response.Public> {
        val entity = LeadMapper.convertDtoToEntity(leadDto);
        val searchResults = leadRepository.find(entity);
        return searchResults.map{LeadMapper.convertEntityToDto(it)}
    }
}
