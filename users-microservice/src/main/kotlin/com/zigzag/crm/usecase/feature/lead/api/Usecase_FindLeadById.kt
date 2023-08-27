package com.zigzag.crm.usecase.feature.lead.api

import com.zigzag.crm.usecase.api.CrmUsecase
import com.zigzag.crm.usecase.feature.lead.dto.LeadDto
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface Usecase_FindLeadById: com.zigzag.crm.usecase.api.CrmUsecase<Mono<LeadDto.Response.Public>, String> {
}
