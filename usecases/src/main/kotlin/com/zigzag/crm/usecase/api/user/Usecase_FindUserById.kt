package com.zigzag.crm.usecase.api.user

import com.zigzag.crm.usecase.api.CrmUsecase
import com.zigzag.crm.usecase.api.user.dto.CrmUserDto
import reactor.core.publisher.Mono

interface Usecase_FindUserById: CrmUsecase<Mono<CrmUserDto.Response.Public>, String> {
}
