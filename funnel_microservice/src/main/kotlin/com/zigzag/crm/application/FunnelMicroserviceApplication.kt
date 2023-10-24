package com.zigzag.crm.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@ComponentScan(basePackages = ["com.zigzag.crm.*"])
@SpringBootApplication
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)//
}
