package com.zigzag.crm.usecase.lead.impl

import com.zigzag.crm.framework.domain.api.features.lead.ILeadRepository
import com.zigzag.crm.usecase.lead.api.Usecase_FindAllLeads
import com.zigzag.crm.usecase.lead.dto.LeadDto
import com.zigzag.crm.usecase.lead.mapper.LeadMapper
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
class Usecase_FindAllLeads_Impl(private val leadRepository: ILeadRepository,
                                private val leadMapper: LeadMapper
) : Usecase_FindAllLeads {
    override fun execute(pageable: Pageable): Flux<LeadDto.Response.Public> {
        val searchResults = leadRepository.findAll(pageable);
        return searchResults.map{leadMapper.convertEntityToDto(it)}
    }
}
