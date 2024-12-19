package com.zigzag.crm.usecase.feature.user.api

import com.zigzag.crm.usecase.feature.user.dto.CrmUserDto
import org.zigzag.crm.common.usecase.CrmUsecase
import reactor.core.publisher.Mono

interface Usecase_SuspendUser: CrmUsecase<Mono<CrmUserDto.Response.Public>, String> {
}