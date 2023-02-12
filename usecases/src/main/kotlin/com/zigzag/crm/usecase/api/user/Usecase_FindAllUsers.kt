package com.zigzag.crm.usecase.api.user

import com.zigzag.crm.usecase.api.CrmUsecase
import com.zigzag.crm.usecase.api.user.dto.CrmUserDto
import reactor.core.publisher.Flux

interface Usecase_FindAllUsers: CrmUsecase<Flux<CrmUserDto.Response.Public>, String> {
}
