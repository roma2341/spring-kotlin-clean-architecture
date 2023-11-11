package com.zigzag.crm
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.config.server.EnableConfigServer

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
class SpringCloudConfigServer
fun main(args: Array<String>) {
    runApplication<SpringCloudConfigServer>(*args)
}


