package com.zigzag.crm.framework.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.context.annotation.ComponentScan

@ComponentScan(basePackages = ["com.zigzag.crm.*"])
@SpringBootApplication
@EnableDiscoveryClient
class UserMicroserviceApplication

fun main(args: Array<String>) {
    runApplication<UserMicroserviceApplication>(*args)
}
