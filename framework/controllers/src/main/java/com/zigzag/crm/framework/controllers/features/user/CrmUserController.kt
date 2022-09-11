package com.zigzag.crm.framework.controllers.features.user

import com.zigzag.crm.usecase.api.dto.user.CrmUserDto
import com.zigzag.crm.usecase.api.feature.user.IUsecaseCreateUser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import javax.annotation.PostConstruct

@RestController
@RequestMapping("/users")
class CrmUserController( private val usecaseCreateUser: IUsecaseCreateUser){

    @PostConstruct
    fun postConstruct(){
        System.out.println("constucted");
    }

    @PostMapping
    fun addUser(userModel: CrmUserDto.Request.Create):CrmUserDto.Response.Public {
        return usecaseCreateUser.execute(userModel);
    }
}
