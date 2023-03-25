package com.zigzag.crm.usecase.api.contact.dto

import com.zigzag.crm.usecase.api.CrmUsecase
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
interface Usecase_CreateContact : CrmUsecase<Mono<CrmContactDto.Response.Public>, CrmContactDto.Request.Create> {
}
