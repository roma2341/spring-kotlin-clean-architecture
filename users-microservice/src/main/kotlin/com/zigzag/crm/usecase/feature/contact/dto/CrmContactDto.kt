package com.zigzag.crm.usecase.feature.contact.dto

enum class CrmContactDto {;
    private interface Id { val id: String? }
    private interface FirstName { val firstName: String? }
    private interface LastName { val lastName: String? }
    private interface Email { val email: String? }
    private interface Phone { val phone: String? }

    enum class Request {;
        public data class Create(
            override val firstName: String? = null,
            override val lastName: String? = null,
            override val email: String? = null,
            override val phone: String? = null): com.zigzag.crm.usecase.feature.contact.dto.CrmContactDto.FirstName,
            com.zigzag.crm.usecase.feature.contact.dto.CrmContactDto.LastName,
            com.zigzag.crm.usecase.feature.contact.dto.CrmContactDto.Email,
            com.zigzag.crm.usecase.feature.contact.dto.CrmContactDto.Phone;
    }

    enum class Response {;
        data class Public(
            override val id: String? = null,
            override val firstName: String? = null,
            override val lastName: String? = null,
            override val email: String? = null,
            override val phone: String? = null
        ):  com.zigzag.crm.usecase.feature.contact.dto.CrmContactDto.Id,
            com.zigzag.crm.usecase.feature.contact.dto.CrmContactDto.FirstName,
            com.zigzag.crm.usecase.feature.contact.dto.CrmContactDto.LastName,
            com.zigzag.crm.usecase.feature.contact.dto.CrmContactDto.Email,
            com.zigzag.crm.usecase.feature.contact.dto.CrmContactDto.Phone
    }

}
