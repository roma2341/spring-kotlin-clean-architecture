
rootProject.name = "crm-clean-architecture"
include("application")
include("domain")
include("usecases")
include("framework")
include("framework:controllers")
include("framework:repositories")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    plugins {
        id("org.springframework.boot") version "3.0.6"
        id("io.spring.dependency-management") version "1.0.12.RELEASE"
        kotlin("jvm") version "1.7.10"
        kotlin("plugin.spring") version "1.7.10"
    }
}
include("framework:graphql")
findProject(":framework:graphql")?.name = "graphql"
include("framework:schedulers")
findProject(":framework:schedulers")?.name = "schedulers"
