import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("kapt")
}

group = "org.zigzag.crm"
version = "1.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
    maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation(enforcedPlatform("org.springframework.cloud:spring-cloud-dependencies:${rootProject.extra.get("spring_cloud_version")}"))
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.cloud:spring-cloud-config-server")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
    compileOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
tasks.register("prepareKotlinBuildScriptModel") {}
tasks.getByName<BootJar>("bootJar") {
    mainClass.set("com.zigzag.crm.application.SpringCloudConfigServer")
}
