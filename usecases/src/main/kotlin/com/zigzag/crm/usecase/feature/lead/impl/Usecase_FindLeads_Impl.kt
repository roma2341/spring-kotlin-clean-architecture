package com.zigzag.crm.usecase.feature.lead.impl

import com.zigzag.crm.framework.domain.api.features.lead.ILeadRepository
import com.zigzag.crm.usecase.feature.lead.api.Usecase_FindLeads
import com.zigzag.crm.usecase.feature.lead.dto.LeadDto
import com.zigzag.crm.usecase.feature.lead.mapper.LeadMapper
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
class Usecase_FindLeads_Impl(private val leadRepository: ILeadRepository,
    private val leadMapper: LeadMapper) : Usecase_FindLeads {
    override fun execute(leadDto: LeadDto.Request.Search): Flux<LeadDto.Response.Public> {
        val entity = leadMapper.convertDtoToEntity(leadDto);
        val searchResults = leadRepository.find(entity);
        return searchResults.map{leadMapper.convertEntityToDto(it)}
    }
}
