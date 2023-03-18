plugins {
    id("java")
    id("org.springframework.boot")
    kotlin("jvm")
    kotlin("plugin.spring")
}

group = "com.zigzag.crm"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    implementation("com.expediagroup:graphql-kotlin-spring-server:6.4.0")
    implementation(projects.usecases)
    implementation(projects.domain)
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
