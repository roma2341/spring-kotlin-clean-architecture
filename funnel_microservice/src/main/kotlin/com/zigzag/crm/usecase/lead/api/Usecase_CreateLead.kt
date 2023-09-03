package com.zigzag.crm.usecase.lead.api

import com.zigzag.crm.usecase.lead.dto.LeadDto
import org.springframework.stereotype.Component
import org.zigzag.crm.common.usecase.CrmUsecase
import reactor.core.publisher.Mono

@Component
interface Usecase_CreateLead :
    CrmUsecase<Mono<LeadDto.Response.Public>, LeadDto.Request.Create> {
}
