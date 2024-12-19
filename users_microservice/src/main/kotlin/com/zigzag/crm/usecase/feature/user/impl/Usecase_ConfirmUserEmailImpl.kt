package com.zigzag.crm.usecase.feature.user.impl

import com.zigzag.crm.usecase.feature.user.api.Usecase_ConfirmUserEmail
import com.zigzag.crm.usecase.feature.user.dto.CrmUserDto
import reactor.core.publisher.Mono

class Usecase_ConfirmUserEmailImpl : Usecase_ConfirmUserEmail {
    override fun execute(id: String): Mono<CrmUserDto.Response.Public> {
        TODO("Not yet implemented")
    }
}