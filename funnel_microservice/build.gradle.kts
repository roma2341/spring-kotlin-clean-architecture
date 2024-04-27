import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("com.google.devtools.ksp")
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
    implementation(kotlin("stdlib"))
    implementation("org.springframework.boot:spring-boot-starter")
    implementation(enforcedPlatform("org.springframework.cloud:spring-cloud-dependencies:${rootProject.extra.get("spring_cloud_version")}"))
    implementation("org.springframework.cloud:spring-cloud-config-client")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation(project(mapOf("path" to ":commons")))
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    implementation("org.springframework.boot:spring-boot-starter-graphql")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
    implementation("org.springdoc:springdoc-openapi-starter-webflux-ui:2.3.0")
    compileOnly("org.projectlombok:lombok:1.18.26")
    annotationProcessor("org.projectlombok:lombok:1.18.26")
    compileOnly("org.springframework.boot:spring-boot-devtools")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
tasks.register("prepareKotlinBuildScriptModel") {}
tasks.getByName<BootJar>("bootJar") {
    mainClass.set("com.zigzag.crm.application.Application")
}
