package com.zigzag.crm.usecase.api.user.dto

enum class CrmUserDto{;
    private interface Id { val id: Long }
    private interface FirstName { val firstName: String }
    private interface LastName { val lastName: String }
    private interface Email{ val email: String }

    enum class Request{;
        public data class Create(
                              override val firstName: String,
                              override val lastName: String,
                              override val email: String): FirstName, LastName, Email;
        fun test(){
            val test = Create("test","test","test");
        }
    }
    enum class Response {;
        data class Public(
            override val id: Long,
            override val firstName: String,
            override val lastName: String,
            override val email: String
        ): Id, FirstName, LastName, Email
    }
}
    /*data class CrmUserDto(val id:Long,
                          val firstName:Long,
                          val lastName:Long,
                          val email:Long)*/

