package com.zigzag.crm.usecase.api.feature.user

import com.zigzag.crm.usecase.api.IUsecase
import com.zigzag.crm.usecase.api.dto.user.CrmUserDto
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
interface IUsecase_CreateUser: IUsecase<Mono<CrmUserDto.Response.Public>, CrmUserDto.Request.Create> {
}
