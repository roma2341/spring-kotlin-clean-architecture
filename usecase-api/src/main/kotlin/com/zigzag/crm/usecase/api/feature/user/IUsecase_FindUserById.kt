package com.zigzag.crm.usecase.api.feature.user

import com.zigzag.crm.usecase.api.IUsecase
import com.zigzag.crm.usecase.api.dto.user.CrmUserDto
import reactor.core.publisher.Mono

interface IUsecase_FindUserById: IUsecase<Mono<CrmUserDto.Response.Public>, Long> {
}
