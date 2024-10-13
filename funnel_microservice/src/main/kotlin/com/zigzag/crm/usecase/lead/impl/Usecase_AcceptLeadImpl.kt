package com.zigzag.crm.usecase.lead.impl

import com.zigzag.crm.usecase.lead.api.Usecase_AcceptLead
import com.zigzag.crm.usecase.lead.dto.LeadDto
import reactor.core.publisher.Mono

class Usecase_AcceptLeadImpl : Usecase_AcceptLead {
    override fun execute(): Mono<LeadDto.Response.Public> {
        TODO("Not yet implemented")
    }
}