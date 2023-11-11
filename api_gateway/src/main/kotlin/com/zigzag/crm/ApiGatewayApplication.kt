import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@ComponentScan(basePackages = ["com.zigzag.crm.*"])
@SpringBootApplication
open class ApiGatewayApplication
fun main(args: Array<String>) {
    runApplication<ApiGatewayApplication>(*args)
}
