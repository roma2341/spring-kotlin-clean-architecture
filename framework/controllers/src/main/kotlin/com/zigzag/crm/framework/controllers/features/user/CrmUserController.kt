package com.zigzag.crm.framework.controllers.features.user

import com.zigzag.crm.usecase.api.dto.user.CrmUserDto
import com.zigzag.crm.usecase.api.feature.user.IUsecase_CreateUser
import com.zigzag.crm.usecase.api.feature.user.IUsecase_FindUserById
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import javax.annotation.PostConstruct

@RestController
@RequestMapping("/users")
class CrmUserController(
    private val usecaseCreateUser: IUsecase_CreateUser,
    private val usecaseFindUserById: IUsecase_FindUserById){

    @PostConstruct
    fun postConstruct(){
        System.out.println("constucted");
    }

    @PostMapping
    fun addUser(userModel: CrmUserDto.Request.Create): Mono<CrmUserDto.Response.Public> {
        return Mono.create(() -> usecaseCreateUser.execute(userModel));
    }
    @GetMapping("/{userId}")
    fun getUser(@PathVariable userId: Long):CrmUserDto.Response.Public {
        return usecaseFindUserById.execute(userId);
    }
}
