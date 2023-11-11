import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.context.annotation.ComponentScan

@ComponentScan(basePackages = ["com.zigzag.crm"])
@SpringBootApplication
@EnableDiscoveryClient
open class ApiGatewayApplication
fun main(args: Array<String>) {
    runApplication<ApiGatewayApplication>(*args)
}
