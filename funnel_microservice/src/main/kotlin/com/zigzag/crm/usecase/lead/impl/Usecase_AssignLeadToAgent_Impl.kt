package com.zigzag.crm.usecase.lead.impl

import com.zigzag.crm.domain.lead.enums.LeadAssignementStatus
import com.zigzag.crm.framework.domain.api.features.lead.ILeadRepository
import com.zigzag.crm.framework.domain.api.features.lead.Lead
import com.zigzag.crm.usecase.lead.api.Usecase_AssignLeadToAgent
import com.zigzag.crm.usecase.lead.dto.AssignLeadToAgentRequest
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Mono

@Component
class Usecase_AssignLeadToAgent_Impl(
    val leadRepository: ILeadRepository
) : Usecase_AssignLeadToAgent {

    override fun execute(arg: AssignLeadToAgentRequest): Mono<Lead> {
        return leadRepository.findById(arg.leadId)
            .switchIfEmpty(Mono.error(ResponseStatusException(HttpStatus.NOT_FOUND, "Lead not found")))
            .doOnNext {
                    it.agentId = arg.agentId
                    it.assignmentStatus = LeadAssignementStatus.PENDING_APPROVAL
                    leadRepository.updateLead(it)
            }
    }

}
