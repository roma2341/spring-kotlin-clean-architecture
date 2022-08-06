package com.zigzag.crm.usecase.user

class UsecaseCreateUser {
    fun execute(request: UsecaseCreateUserRequest) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

data class UsecaseCreateUserRequest(val firstName:Long, val lastName:Long, val email:Long)
data class UsecaseCreateUserResponse(val userId:Long)
