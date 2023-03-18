package com.zigzag.crm.framework.graphql.mutation

import com.expediagroup.graphql.server.operations.Mutation
import com.zigzag.crm.usecase.api.user.Usecase_CreateUser
import com.zigzag.crm.usecase.api.user.dto.CrmUserDto
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class CrmUserMutation(private val usecaseCreateUser: Usecase_CreateUser): Mutation {

    fun newUser(user: CrmUserDto.Request.Create): Mono<CrmUserDto.Response.Public> {
        return usecaseCreateUser.execute(user);
    }
}
