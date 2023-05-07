import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20-Beta"
    kotlin("plugin.spring") version "1.7.20-Beta"
    id("org.springframework.boot")
    id("io.spring.dependency-management") version "1.0.12.RELEASE"
}

group = "com.zigzag.crm"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}
allprojects {
    ext {
        set("spring_boot_version", "3.0.6")
        set("jetbrains_kotlin_version", "1.3.41")
        set("junit_version", "5.8.1")
    }
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
}


dependencyManagement {
    dependencies {
        dependency("org.springframework.boot:spring-boot-starter:${rootProject.extra.get("spring_boot_version")}")
    }
}
