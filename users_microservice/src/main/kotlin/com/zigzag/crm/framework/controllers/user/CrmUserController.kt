package com.zigzag.crm.framework.controllers.user

import com.zigzag.crm.usecase.feature.user.api.Usecase_CreateUser
import com.zigzag.crm.usecase.feature.user.api.Usecase_FindAllUsers
import com.zigzag.crm.usecase.feature.user.api.Usecase_FindUserById
import com.zigzag.crm.usecase.feature.user.dto.CrmUserDto
import jakarta.annotation.PostConstruct
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("api/users/v1")
class CrmUserController(
    private val usecaseCreateUser: Usecase_CreateUser,
    private val usecaseFindUserById: Usecase_FindUserById,
    private val usecaseFindAllUsers: Usecase_FindAllUsers
){

    @PostMapping
    fun addUser(@RequestBody userModel: CrmUserDto.Request.Create): Mono<CrmUserDto.Response.Public> {
        return usecaseCreateUser.execute(userModel);
    }
    @GetMapping("/{userId}")
    fun getUser(@PathVariable userId: String): Mono<CrmUserDto.Response.Public> {
        return usecaseFindUserById.execute(userId);
    }
    @GetMapping()
    fun getUsers(): Flux<CrmUserDto.Response.Public> {
        return usecaseFindAllUsers.execute();
    }
}
