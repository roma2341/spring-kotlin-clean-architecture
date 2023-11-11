@ComponentScan(basePackages = ["com.zigzag.crm.*"])
@SpringBootApplication
class ApiGatewayApplication
fun main(args: Array<String>) {
    runApplication<ApiGatewayApplication>(*args)
}
