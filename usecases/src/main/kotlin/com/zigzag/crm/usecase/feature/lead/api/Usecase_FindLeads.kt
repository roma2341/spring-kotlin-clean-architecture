package com.zigzag.crm.usecase.feature.lead.api

import com.zigzag.crm.usecase.core.api.CrmUsecase
import com.zigzag.crm.usecase.feature.lead.dto.LeadDto
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface Usecase_FindLeads: CrmUsecase<Flux<LeadDto.Response.Public>, LeadDto.Request.Search> {
}
