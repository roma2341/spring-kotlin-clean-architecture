package com.zigzag.crm.usecase.lead.api

import com.zigzag.crm.usecase.lead.dto.LeadDto
import org.zigzag.crm.common.usecase.CrmUsecase
import reactor.core.publisher.Mono

interface Usecase_FindLeadById: CrmUsecase<Mono<LeadDto.Response.Public>, String> {
}
