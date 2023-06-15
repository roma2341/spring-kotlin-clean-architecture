package com.zigzag.crm.usecase.feature.lead.impl

import com.zigzag.crm.framework.domain.api.features.lead.ILeadRepository
import com.zigzag.crm.usecase.feature.lead.api.Usecase_FindLeadById
import com.zigzag.crm.usecase.feature.lead.dto.LeadDto
import com.zigzag.crm.usecase.feature.lead.mapper.LeadMapper
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class Usecase_FindLeadById_Impl(private val leadRepository: ILeadRepository,
                                private val leadMapper: LeadMapper
) : Usecase_FindLeadById {
    override fun execute(id: String): Mono<LeadDto.Response.Public> {
        val lead = leadRepository.findById(id);
        return lead.map{leadMapper.convertEntityToDto(it)}
    }
}
