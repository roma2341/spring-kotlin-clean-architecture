package com.zigzag.crm.usecase.feature.contact.mapper

import com.zigzag.crm.framework.domain.api.features.contact.CrmContact
import com.zigzag.crm.usecase.feature.contact.dto.CrmContactDto
import io.mcarle.konvert.api.Konverter
import io.mcarle.konvert.injector.spring.KComponent

@Konverter
@KComponent
interface CrmContactMapper {
    fun convertDtoToEntity(contactDto: CrmContactDto.Request.Create): CrmContact
    fun convertEntityToDto(contact: CrmContact): CrmContactDto.Response.Public
}
