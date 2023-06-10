package com.zigzag.crm.usecase.feature.lead.api

import com.zigzag.crm.framework.domain.api.features.lead.Lead
import com.zigzag.crm.usecase.core.api.CrmUsecase
import com.zigzag.crm.usecase.feature.lead.dto.AssignLeadToAgentRequest
import com.zigzag.crm.usecase.feature.lead.dto.LeadDto
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono


interface Usecase_AssignLeadToAgent : CrmUsecase<Mono<Lead>, AssignLeadToAgentRequest> {
}
