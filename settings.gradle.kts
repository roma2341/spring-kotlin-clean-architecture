
rootProject.name = "crm-clean-architecture"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    plugins {
        id("org.springframework.boot") version "3.0.6"
        id("io.spring.dependency-management") version "1.0.12.RELEASE"
        kotlin("jvm") version "1.7.10"
        kotlin("plugin.spring") version "1.7.10"
    }
}
include("users_microservice")
include("funnel_microservice")
include("commons")
include("config_service")
include("api_gateway")
include("service_registry")
