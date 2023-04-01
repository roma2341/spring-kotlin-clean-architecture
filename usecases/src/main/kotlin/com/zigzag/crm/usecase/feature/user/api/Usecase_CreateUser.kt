package com.zigzag.crm.usecase.feature.user.api

import com.zigzag.crm.usecase.core.api.CrmUsecase
import com.zigzag.crm.usecase.feature.user.dto.CrmUserDto
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
interface Usecase_CreateUser: CrmUsecase<Mono<CrmUserDto.Response.Public>, CrmUserDto.Request.Create> {
}
