package com.zigzag.crm.usecase.feature.contact.api

import com.zigzag.crm.usecase.core.api.CrmUsecase
import com.zigzag.crm.usecase.feature.contact.dto.CrmContactDto
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
interface Usecase_CreateContact : CrmUsecase<Mono<CrmContactDto.Response.Public>, CrmContactDto.Request.Create> {
}
