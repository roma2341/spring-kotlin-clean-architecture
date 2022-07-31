import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("java")
    id("org.springframework.boot")
    kotlin("jvm")
    kotlin("plugin.spring")
}

group = "org.zigzag"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
    maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:${rootProject.extra.get("junit_version")}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${rootProject.extra.get("junit_version")}")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
