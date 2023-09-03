package com.zigzag.crm.usecase.feature.user.api

import com.zigzag.crm.usecase.feature.user.dto.CrmUserDto
import org.springframework.stereotype.Component
import org.zigzag.crm.common.usecase.CrmUsecase
import reactor.core.publisher.Mono

@Component
interface Usecase_CreateUser:
    CrmUsecase<Mono<CrmUserDto.Response.Public>, CrmUserDto.Request.Create> {
}
