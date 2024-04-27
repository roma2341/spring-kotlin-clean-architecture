package com.zigzag.crm.usecase.feature.contact.mapper

import com.zigzag.crm.framework.domain.api.features.contact.CrmContact
import com.zigzag.crm.usecase.feature.contact.dto.CrmContactDto

abstract class CrmContactMapper {
    companion object {
        fun convertDtoToEntity(contactDto: CrmContactDto.Request.Create): CrmContact {
            return CrmContact(
                email = contactDto.email,
                firstName = contactDto.firstName,
                lastName = contactDto.lastName,
                phone = contactDto.phone,
                ownerId = null,
                id = null
            )
        }

        fun convertEntityToDto(contact: CrmContact): CrmContactDto.Response.Public {
            return CrmContactDto.Response.Public(
                email = contact.email,
                firstName = contact.firstName,
                lastName = contact.lastName,
                phone = contact.phone
            )
        }
    }
}
