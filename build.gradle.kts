import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

group = "com.zigzag.crm"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "21"
}
allprojects {
    ext {
        set("spring_boot_version", "3.1.3")
        set("mcarle_konvert_version", "3.2.0")
        set("mcarle_konvert_spring_injector_version", "3.1.0")
        set("konvert_spring_injector_version", "2.1.0")
        set("spring_cloud_version", "2022.0.4")
        set("jetbrains_kotlin_version", "1.9.23")
        set("junit_version", "5.9.3")
    }
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
}

subprojects {
    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "21"
        }
    }
}

dependencyManagement {
    dependencies {
        dependency("org.springframework.boot:spring-boot-starter:${rootProject.extra.get("spring_boot_version")}")
    }
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${rootProject.extra.get("spring_cloud_version")}")
    }
}
