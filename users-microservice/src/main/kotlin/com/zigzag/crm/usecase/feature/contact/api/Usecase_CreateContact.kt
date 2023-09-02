package com.zigzag.crm.usecase.feature.contact.api

import com.zigzag.crm.usecase.feature.contact.dto.CrmContactDto
import org.springframework.stereotype.Component
import org.zigzag.crm.common.usecase.CrmUsecase
import reactor.core.publisher.Mono

@Component
interface Usecase_CreateContact :
    CrmUsecase<Mono<CrmContactDto.Response.Public>, CrmContactDto.Request.Create> {
}
