package com.zigzag.crm.usecase.feature.contact.mapper

import com.zigzag.crm.framework.domain.api.features.contact.CrmContact
import com.zigzag.crm.usecase.api.contact.dto.CrmContactDto
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface CrmContactMapper {
    fun convertDtoToEntity(contactDto: CrmContactDto.Request.Create): CrmContact
    fun convertEntityToDto(contact: CrmContact): CrmContactDto.Response.Public
}
