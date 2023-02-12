package com.zigzag.crm.usecase.api.user

import com.zigzag.crm.usecase.api.IUsecase
import com.zigzag.crm.usecase.api.user.dto.CrmUserDto
import reactor.core.publisher.Mono

interface Usecase_FindUserById: IUsecase<Mono<CrmUserDto.Response.Public>, String> {
}
