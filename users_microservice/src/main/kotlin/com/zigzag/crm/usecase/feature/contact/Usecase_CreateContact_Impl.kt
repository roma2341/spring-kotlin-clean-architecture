package com.zigzag.crm.usecase.feature.contact

import com.zigzag.crm.usecase.feature.contact.dto.CrmContactDto
import com.zigzag.crm.usecase.feature.contact.api.Usecase_CreateContact
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class Usecase_CreateContact_Impl : Usecase_CreateContact {
    override fun execute(arg: CrmContactDto.Request.Create): Mono<CrmContactDto.Response.Public> {
        TODO("Not yet implemented")
    }
}
