package com.zigzag.crm.usecase.feature.contact.dto

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

    enum class Response {;
        data class Public(
            override val id: String?,
            override val firstName: String?,
            override val lastName: String?,
            override val email: String?,
            override val phone: String?
        ):  Id, FirstName, LastName, Email, Phone
    }

}
