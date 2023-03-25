package com.zigzag.crm.usecase.api.contact.dto

import com.zigzag.crm.usecase.api.product.dto.CrmProductDto

enum class CrmContactDto {;
    private interface Id { val id: String? }
    private interface FirstName { val firstName: String? }
    private interface LastName { val lastName: String? }
    private interface Email { val email: String? }
    private interface Phone { val phone: String? }

    enum class Request {;
        public data class Create(
            override val firstName: String?,
            override val lastName: String?,
            override val email: String?,
            override val phone: String?): FirstName, LastName, Email, Phone;
    }
}
