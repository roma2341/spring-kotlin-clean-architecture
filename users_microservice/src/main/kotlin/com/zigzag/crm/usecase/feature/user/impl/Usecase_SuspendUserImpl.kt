package com.zigzag.crm.usecase.feature.user.impl

import com.zigzag.crm.usecase.feature.user.api.Usecase_SuspendUser
import com.zigzag.crm.usecase.feature.user.dto.CrmUserDto
import reactor.core.publisher.Mono

class Usecase_SuspendUserImpl : Usecase_SuspendUser {
    override fun execute(id: String): Mono<CrmUserDto.Response.Public> {
        TODO("Not yet implemented")
    }
}