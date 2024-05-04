package com.zigzag.crm.framework.rest.user;

import com.zigzag.crm.framework.rest.user.dto.CrmUserDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(name = "users-microservice")
interface CrmUserRestClient {
    @GetMapping("api/user/v1")
    fun getUsers(): List<CrmUserDto.Response.Public>
}
