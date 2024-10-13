package com.zigzag.crm.usecase.lead.api

import com.zigzag.crm.usecase.lead.dto.AcceptLeadArgs
import org.zigzag.crm.common.usecase.CrmUsecase
import reactor.core.publisher.Mono

interface Usecase_AcceptLead: CrmUsecase<Mono<Nothing>, AcceptLeadArgs> {
}
