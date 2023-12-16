import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.PredicateSpec
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.http.HttpMethod


@ComponentScan(basePackages = ["com.zigzag.crm"])
@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(info = Info(title = "API Gateway", version = "1.0", description = "Documentation API Gateway v1.0"))

open class ApiGatewayApplication
fun main(args: Array<String>) {
    runApplication<ApiGatewayApplication>(*args)
}

@Bean
fun routeLocator(builder: RouteLocatorBuilder): RouteLocator {
    return builder
        .routes()
        .route { r: PredicateSpec ->
            r.path(
                "/api/user/v3/api-docs"
            ).and().method(HttpMethod.GET).uri("lb://users-microservice")
        }
        .build()
}
