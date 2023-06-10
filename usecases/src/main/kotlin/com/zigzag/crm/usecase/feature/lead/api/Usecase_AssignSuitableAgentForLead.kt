package com.zigzag.crm.usecase.feature.lead.api

import com.zigzag.crm.framework.domain.api.features.lead.Lead
import com.zigzag.crm.usecase.core.api.CrmUsecase
import reactor.core.publisher.Mono

interface Usecase_AssignSuitableAgentForLead : CrmUsecase<Mono<Lead>, String>
