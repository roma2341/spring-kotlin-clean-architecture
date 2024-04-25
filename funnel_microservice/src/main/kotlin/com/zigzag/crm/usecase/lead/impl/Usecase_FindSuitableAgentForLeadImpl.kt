package com.zigzag.crm.usecase.lead.impl

import com.zigzag.crm.framework.domain.api.features.lead.Lead
import com.zigzag.crm.framework.mongo.lead.LeadRepository
import com.zigzag.crm.usecase.lead.api.Usecase_FindSuitableAgentForLead
import com.zigzag.crm.usecase.lead.dto.AssignLeadToAgentRequest
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class Usecase_FindSuitableAgentForLeadImpl(private val leadRepository: LeadRepository) : Usecase_FindSuitableAgentForLead {
    override fun execute(leadId: String): Mono<Lead> {
        var leadToSearch = Lead();
        return leadRepository.find(leadToSearch).next();
    }
}
