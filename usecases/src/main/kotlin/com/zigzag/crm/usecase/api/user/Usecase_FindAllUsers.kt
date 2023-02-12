package com.zigzag.crm.usecase.api.user

import com.zigzag.crm.usecase.api.IUsecase
import com.zigzag.crm.usecase.api.user.dto.CrmUserDto
import reactor.core.publisher.Flux

interface Usecase_FindAllUsers: IUsecase<Flux<CrmUserDto.Response.Public>, String> {
}
