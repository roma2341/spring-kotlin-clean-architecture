package com.zigzag.crm.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.ComponentScan
import reactivefeign.spring.config.EnableReactiveFeignClients

@ComponentScan(basePackages = ["com.zigzag.crm.*"])
@EnableDiscoveryClient
@EnableReactiveFeignClients(basePackages = ["com.zigzag.crm.*"])
@SpringBootApplication
class FunnelMicroserviceApplication

fun main(args: Array<String>) {
    runApplication<FunnelMicroserviceApplication>(*args)
}
