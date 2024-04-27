package com.zigzag.crm.usecase.lead.impl

import com.zigzag.crm.framework.domain.api.features.lead.Lead
import com.zigzag.crm.usecase.lead.api.Usecase_AssignLeadToAgent
import com.zigzag.crm.usecase.lead.api.Usecase_AssignSuitableAgentForLead
import com.zigzag.crm.usecase.lead.api.Usecase_FindSuitableAgentForLead
import com.zigzag.crm.usecase.lead.dto.AssignLeadToAgentRequest
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class Usecase_AssignSuitableAgentForLead_Impl(
    val usecaseAssignLeadToAgent: Usecase_AssignLeadToAgent
    val userRepository
) : Usecase_AssignSuitableAgentForLead {
    override fun execute(leadId: String): Mono<Lead> {
        //return usecaseFindSuitableAgentForLead.execute()
        return  usecaseAssignLeadToAgent.execute(
            AssignLeadToAgentRequest(
            leadId = leadId,
            agentId = ag)
        );
    }
}
