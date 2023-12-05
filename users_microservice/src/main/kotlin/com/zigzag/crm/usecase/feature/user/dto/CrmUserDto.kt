package com.zigzag.crm.usecase.feature.user.dto

enum class CrmUserDto{;
    private interface Id { var id: String? }
    private interface FirstName { var firstName: String? }
    private interface LastName { var lastName: String? }
    private interface Email{ var email: String? }

    enum class Request{;
        public data class Create(
                              override var firstName: String?,
                              override var lastName: String?,
                              override var email: String?): FirstName, LastName, Email;
        fun test(){
            val test = com.zigzag.crm.usecase.feature.user.dto.CrmUserDto.Request.Create("test", "test", "test");
        }
    }
    enum class Response {;
        data class Public(
            override var id: String? = null,
            override var firstName: String? = null,
            override var lastName: String? = null,
            override var email: String?
        ): Id, FirstName, LastName, Email
    }
}
    /*data class CrmUserDto(val id:Long,
                          val firstName:Long,
                          val lastName:Long,
                          val email:Long)*/

