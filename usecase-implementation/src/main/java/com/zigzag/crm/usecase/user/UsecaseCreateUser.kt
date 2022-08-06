package com.zigzag.crm.usecase.user

import com.zigzag.crm.usecase.api.IUsecase
import com.zigzag.crm.usecase.api.IUsecaseNoArg
import org.zigzag.repository.api.ICrmUserRepository

class UsecaseCreateUser(private val userRepository: ICrmUserRepository): IUsecase<UsecaseCreateUserResponse,UsecaseCreateUserRequest>{
    override fun execute(request: UsecaseCreateUserRequest):UsecaseCreateUserResponse {
        return userRepository.createUser(request.user);
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

data class UsecaseCreateUserRequest(val firstName:Long, val lastName:Long, val email:Long)
data class UsecaseCreateUserResponse(val userId:Long)
