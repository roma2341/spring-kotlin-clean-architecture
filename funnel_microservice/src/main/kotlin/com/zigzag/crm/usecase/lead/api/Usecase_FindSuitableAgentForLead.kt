package com.zigzag.crm.usecase.lead.api

import com.zigzag.crm.framework.domain.api.features.lead.Lead
import com.zigzag.crm.usecase.lead.dto.AssignLeadToAgentRequest
import org.zigzag.crm.common.usecase.CrmUsecase
import reactor.core.publisher.Mono


interface Usecase_FindSuitableAgentForLead : CrmUsecase<Mono<Lead>, String> {
}
