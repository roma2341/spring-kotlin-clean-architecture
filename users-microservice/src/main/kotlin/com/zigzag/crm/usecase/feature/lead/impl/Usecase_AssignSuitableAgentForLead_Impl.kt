package com.zigzag.crm.usecase.feature.lead.impl

import com.zigzag.crm.framework.domain.api.features.lead.ILeadRepository
import com.zigzag.crm.framework.domain.api.features.lead.Lead
import com.zigzag.crm.framework.domain.api.features.user.ICrmUserRepository
import com.zigzag.crm.usecase.feature.lead.api.Usecase_AssignLeadToAgent
import com.zigzag.crm.usecase.feature.lead.api.Usecase_AssignSuitableAgentForLead
import com.zigzag.crm.usecase.feature.lead.dto.AssignLeadToAgentRequest
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Mono

@Component
class Usecase_AssignSuitableAgentForLead_Impl(
    val userRepository: ICrmUserRepository,
    val usecaseAssignLeadToAgent: Usecase_AssignLeadToAgent
) : com.zigzag.crm.usecase.feature.lead.api.Usecase_AssignSuitableAgentForLead {
    override fun execute(leadId: String): Mono<Lead> {
        val userMono =  userRepository.findFirst().switchIfEmpty(Mono.error(ResponseStatusException(HttpStatus.NOT_FOUND, "Agent not found")))
        return userMono.flatMap {
            usecaseAssignLeadToAgent.execute(AssignLeadToAgentRequest(leadId, it.id!!))
        }
    }
}
