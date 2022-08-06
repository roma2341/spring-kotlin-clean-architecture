package com.zigzag.crm.framework.controllers.features.user

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
@RequestMapping("/user")
class CrmUserController {
    constructor()  {
        System.out.println("constucted");
    }

    @PostConstruct
    fun postConstruct(){
        System.out.println("constucted");
    }

    @PostMapping(path = ["/user"],
        produces = [MediaType.APPLICATION_STREAM_JSON_VALUE])
    fun getNumbers() = Flux.range(1, 100)
}
