package com.zigzag.crm.usecase.lead.api

import com.zigzag.crm.usecase.lead.dto.LeadDto
import org.zigzag.crm.common.usecase.CrmUsecase
import reactor.core.publisher.Flux

interface Usecase_FindLeads:
    CrmUsecase<Flux<LeadDto.Response.Public>, LeadDto.Request.Search> {
}
