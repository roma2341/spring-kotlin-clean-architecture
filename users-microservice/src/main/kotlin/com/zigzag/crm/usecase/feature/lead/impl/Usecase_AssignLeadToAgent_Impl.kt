package com.zigzag.crm.usecase.feature.lead.impl

import com.zigzag.crm.framework.domain.api.features.lead.ILeadRepository
import com.zigzag.crm.framework.domain.api.features.lead.Lead
import com.zigzag.crm.framework.domain.api.features.user.ICrmUserRepository
import com.zigzag.crm.usecase.feature.lead.api.Usecase_AssignLeadToAgent
import com.zigzag.crm.usecase.feature.lead.dto.AssignLeadToAgentRequest
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Mono

@Component
class Usecase_AssignLeadToAgent_Impl(
    val userRepository: ICrmUserRepository,
    val leadRepository: ILeadRepository
) : Usecase_AssignLeadToAgent {

    override fun execute(arg: AssignLeadToAgentRequest): Mono<Lead> {
        return userRepository.findById(arg.agentId)
            .switchIfEmpty(Mono.error( ResponseStatusException(HttpStatus.NOT_FOUND, "Agent not found")))
            .flatMap { leadRepository.findById(arg.leadId)}
            .switchIfEmpty(Mono.error(ResponseStatusException(HttpStatus.NOT_FOUND, "Lead not found")))
            .doOnNext {
                    it.agentId = arg.agentId
                    leadRepository.updateLead(it)
            }
    }

}
