package com.zigzag.crm.usecase.lead.api

import com.zigzag.crm.usecase.lead.dto.LeadDto
import org.zigzag.crm.common.usecase.CrmUsecaseNoArg
import reactor.core.publisher.Mono

interface Usecase_AcceptLead: CrmUsecaseNoArg<Mono<LeadDto.Response.Public>> {
}
