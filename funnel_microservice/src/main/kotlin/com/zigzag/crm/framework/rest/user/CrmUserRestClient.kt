package com.zigzag.crm.framework.rest.user;

import com.zigzag.crm.framework.rest.user.dto.CrmUserDto
import org.springframework.web.bind.annotation.GetMapping
import reactivefeign.spring.config.ReactiveFeignClient
import reactor.core.publisher.Flux

@ReactiveFeignClient(name = "users-microservice")
interface CrmUserRestClient {
    @GetMapping("api/user/v1")
    fun getUsers(): Flux<CrmUserDto.Response.Public>
}
