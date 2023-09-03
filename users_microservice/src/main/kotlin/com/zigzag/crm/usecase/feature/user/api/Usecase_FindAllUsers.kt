package com.zigzag.crm.usecase.feature.user.api

import com.zigzag.crm.usecase.feature.user.dto.CrmUserDto
import org.springframework.stereotype.Component
import org.zigzag.crm.common.usecase.CrmUsecaseNoArg
import reactor.core.publisher.Flux

@Component
interface Usecase_FindAllUsers: CrmUsecaseNoArg<Flux<CrmUserDto.Response.Public>> {
}
