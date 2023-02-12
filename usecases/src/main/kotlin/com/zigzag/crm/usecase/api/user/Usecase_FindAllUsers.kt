package com.zigzag.crm.usecase.api.user

import com.zigzag.crm.usecase.api.CrmUsecase
import com.zigzag.crm.usecase.api.CrmUsecaseNoArg
import com.zigzag.crm.usecase.api.user.dto.CrmUserDto
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
interface Usecase_FindAllUsers: CrmUsecaseNoArg<Flux<CrmUserDto.Response.Public>> {
}
