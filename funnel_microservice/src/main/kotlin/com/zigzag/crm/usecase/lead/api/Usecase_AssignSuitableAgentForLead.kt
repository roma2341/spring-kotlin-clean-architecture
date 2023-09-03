package com.zigzag.crm.usecase.lead.api

import com.zigzag.crm.framework.domain.api.features.lead.Lead
import org.zigzag.crm.common.usecase.CrmUsecase
import reactor.core.publisher.Mono

interface Usecase_AssignSuitableAgentForLead : CrmUsecase<Mono<Lead>, String>
