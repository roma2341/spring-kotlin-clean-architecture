package com.zigzag.crm.usecase.lead.api

import com.zigzag.crm.usecase.lead.dto.LeadDto
import org.springframework.data.domain.Pageable
import org.zigzag.crm.common.usecase.CrmUsecase
import reactor.core.publisher.Flux

interface Usecase_FindAllLeads:
    CrmUsecase<Flux<LeadDto.Response.Public>, Pageable> {
}
