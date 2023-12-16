package com.zigzag.crm.config.openapi

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.servers.Server
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.List


@OpenAPIDefinition
@Configuration
class OpenApiConfiguration {
    @Bean
    fun customOpenAPI(
        @Value("\${openapi.service.title}") serviceTitle: String?,
        @Value("\${openapi.service.version}") serviceVersion: String?,
        @Value("\${openapi.service.url}") url: String?
    ): OpenAPI {
        return OpenAPI()
            .servers(List.of(Server().url(url)))
            .info(Info().title(serviceTitle).version(serviceVersion))
    }
}
