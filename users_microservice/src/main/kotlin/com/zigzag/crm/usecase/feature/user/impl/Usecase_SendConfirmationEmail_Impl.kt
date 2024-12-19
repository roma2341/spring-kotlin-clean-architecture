package com.zigzag.crm.usecase.feature.user.impl

import com.zigzag.crm.usecase.feature.user.api.Usecase_SendConfirmationEmail
import com.zigzag.crm.usecase.feature.user.dto.CrmUserDto
import reactor.core.publisher.Mono

class Usecase_SendConfirmationEmail_Impl : Usecase_SendConfirmationEmail {
    override fun execute(arg: String): Mono<CrmUserDto.Response.Public> {
        TODO("Not yet implemented")
    }
}