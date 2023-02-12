package com.zigzag.crm.framework.controllers.features.user

import com.zigzag.crm.usecase.api.user.Usecase_CreateUser
import com.zigzag.crm.usecase.api.user.Usecase_FindUserById
import com.zigzag.crm.usecase.api.user.dto.CrmUserDto
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import javax.annotation.PostConstruct

@RestController
@RequestMapping("/users")
class CrmUserController(
    private val usecaseCreateUser: Usecase_CreateUser,
    private val usecaseFindUserById: Usecase_FindUserById
){

    @PostConstruct
    fun postConstruct(){
        System.out.println("constucted");
    }

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
        return u
    }
}
