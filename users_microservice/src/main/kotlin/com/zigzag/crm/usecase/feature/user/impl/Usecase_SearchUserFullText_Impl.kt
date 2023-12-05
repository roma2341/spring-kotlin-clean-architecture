package com.zigzag.crm.usecase.feature.user.impl

import com.zigzag.crm.usecase.feature.user.api.Usecase_SearchUserFullText
import com.zigzag.crm.usecase.feature.user.dto.CrmUserDto
import reactor.core.publisher.Flux

class Usecase_SearchUserFullText_Impl : Usecase_SearchUserFullText {
    override fun execute(arg: String): Flux<CrmUserDto.Response.Public> {
        return Flux.empty();
    }
}
