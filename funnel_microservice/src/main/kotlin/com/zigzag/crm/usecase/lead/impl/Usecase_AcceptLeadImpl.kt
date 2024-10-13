package com.zigzag.crm.usecase.lead.impl

import com.zigzag.crm.framework.domain.api.features.lead.ILeadRepository
import com.zigzag.crm.usecase.lead.api.Usecase_AcceptLead
import com.zigzag.crm.usecase.lead.dto.AcceptLeadArgs
import com.zigzag.crm.usecase.lead.dto.LeadDto
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Mono

@Component
class Usecase_AcceptLeadImpl(val leadRepository: ILeadRepository) : Usecase_AcceptLead {
    override fun execute(args: AcceptLeadArgs): Mono<Nothing> {
        val lead = leadRepository.findById(args.leadId)
            .switchIfEmpty(Mono.error(ResponseStatusException(HttpStatus.NOT_FOUND, "Lead not found")));
        //TODO check if current user is owner of the lead
        return lead.map { it -> null };
    }
}