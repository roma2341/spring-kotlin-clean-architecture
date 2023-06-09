package com.zigzag.crm.usecase.feature.lead.mapper

import com.zigzag.crm.framework.domain.api.features.lead.ILeadRepository
import com.zigzag.crm.framework.domain.api.features.lead.Lead
import com.zigzag.crm.framework.domain.api.features.user.ICrmUserRepository
import com.zigzag.crm.usecase.feature.lead.api.Usecase_AssignLeadToAgent
import com.zigzag.crm.usecase.feature.lead.api.Usecase_FindSuitableAgentForLead
import com.zigzag.crm.usecase.feature.lead.dto.AssignLeadToAgentRequest
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Mono

@Component
class Usecase_FindSuitableAgentForLead_Impl(
    val leadRepository: ILeadRepository,
    val userRepository: ICrmUserRepository,
    val usecaseAssignedLeadToAgent: Usecase_AssignLeadToAgent
) : Usecase_FindSuitableAgentForLead {
    override fun execute(leadId: String): Mono<Lead> {
        val leadMono =  leadRepository.findById(leadId).switchIfEmpty(Mono.error(ResponseStatusException(HttpStatus.NOT_FOUND, "Lead not found")))
        val userMono =  userRepository.findFirst().switchIfEmpty(Mono.error(ResponseStatusException(HttpStatus.NOT_FOUND, "Agent not found")))
        return leadMono.zipWith(userMono).flatMap {
            val lead = it.t1;
            val user = it.t2;
            usecaseAssignedLeadToAgent.execute(AssignLeadToAgentRequest(leadId, user.id!!))
        }
    }
}
