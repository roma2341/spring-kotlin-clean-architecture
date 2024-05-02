package com.zigzag.crm.framework.rest.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(name = "users-microservice")
interface UserRestClient {
    @RequestMapping(method = RequestMethod.GET, value = "api/user/v1")
    List<> iFailSometimes();
}
