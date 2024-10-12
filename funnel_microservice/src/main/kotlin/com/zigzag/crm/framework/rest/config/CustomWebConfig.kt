package com.zigzag.crm.framework.rest.config

import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.web.ReactivePageableHandlerMethodArgumentResolver
import org.springframework.web.reactive.config.WebFluxConfigurer
import org.springframework.web.reactive.result.method.HandlerMethodArgumentResolver

@Configuration
class CustomWebConfig : WebFluxConfigurer {
    @PostConstruct
    fun init() {
        println("CustomWebConfig init")
    }

    @Bean
    fun reactivePageableHandlerMethodArgumentResolver(): HandlerMethodArgumentResolver {
        return ReactivePageableHandlerMethodArgumentResolver()
    }
}
