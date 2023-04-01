package com.zigzag.crm.usecase.feature.lead.dto

enum class LeadDto{;
    private interface Id { val id: String? }
    private interface FirstName { val firstName: String? }
    private interface LastName { val lastName: String? }
    private interface Email{ val email: String? }

    enum class Request{;
        public data class Create(
                              override val firstName: String?,
                              override val lastName: String?,
                              override val email: String?): FirstName, LastName, Email;
    }
    enum class Response {;
        data class Public(
            override val id: String?,
            override val firstName: String?,
            override val lastName: String?,
            override val email: String?
        ): Id, FirstName, LastName, Email
    }
}

