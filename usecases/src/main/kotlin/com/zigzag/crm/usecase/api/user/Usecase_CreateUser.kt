package com.zigzag.crm.usecase.api.user

import com.zigzag.crm.usecase.api.CrmUsecase
import com.zigzag.crm.usecase.api.user.dto.CrmUserDto
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
interface Usecase_CreateUser: CrmUsecase<Mono<CrmUserDto.Response.Public>, CrmUserDto.Request.Create> {
}
