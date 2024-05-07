
rootProject.name = "crm-clean-architecture"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    plugins {
        id("org.springframework.boot") version "3.0.6"
        id("io.spring.dependency-management") version "1.1.3"
        kotlin("jvm") version "1.9.23"
        kotlin("plugin.spring") version "1.9.23"
        id("com.google.devtools.ksp") version  "1.9.23-1.0.20" apply false //"1.9.23-1.0.20"
    }
}
include("users_microservice")
include("funnel_microservice")
include("product_catalog_microservice")
include("commons")
include("config_service")
include("api_gateway")
include("service_registry")
