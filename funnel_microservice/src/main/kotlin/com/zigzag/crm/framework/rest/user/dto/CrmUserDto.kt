package com.zigzag.crm.framework.rest.user.dto

enum class CrmUserDto{;
    private interface Id { var id: String }
    private interface FirstName { var firstName: String? }
    private interface LastName { var lastName: String? }
    private interface Email{ var email: String? }

    enum class Request{;
        public data class Create(
            override var firstName: String?,
            override var lastName: String?,
            override var email: String?): FirstName, LastName, Email;
    }
    enum class Response {;
        data class Public(
            override var id: String,
            override var firstName: String? = null,
            override var lastName: String? = null,
            override var email: String?
        ): Id, FirstName, LastName, Email
    }
}