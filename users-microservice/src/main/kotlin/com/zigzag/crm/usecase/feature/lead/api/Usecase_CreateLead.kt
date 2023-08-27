package com.zigzag.crm.usecase.feature.lead.api

import com.zigzag.crm.usecase.api.CrmUsecase
import com.zigzag.crm.usecase.feature.lead.dto.LeadDto
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
interface Usecase_CreateLead :
    com.zigzag.crm.usecase.api.CrmUsecase<Mono<LeadDto.Response.Public>, LeadDto.Request.Create> {
}
