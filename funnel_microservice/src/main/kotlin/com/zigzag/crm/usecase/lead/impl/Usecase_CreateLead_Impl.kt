package com.zigzag.crm.usecase.lead.impl

import com.zigzag.crm.framework.domain.api.features.lead.ILeadRepository
import com.zigzag.crm.usecase.lead.api.Usecase_CreateLead
import com.zigzag.crm.usecase.lead.dto.LeadDto
import com.zigzag.crm.usecase.lead.mapper.LeadMapper
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class Usecase_CreateLead_Impl(private val leadRepository: ILeadRepository,
                              private val leadMapper: LeadMapper
): Usecase_CreateLead {
    override fun execute(leadDto: LeadDto.Request.Create): Mono<LeadDto.Response.Public> {
        var user = leadMapper.convertDtoToEntity(leadDto);
        var persistedUser = leadRepository.createLead(user);
        return persistedUser.map{lead -> leadMapper.convertEntityToDto(lead)};
    }
}
