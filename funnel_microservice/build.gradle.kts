import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("kapt")
}

group = "org.zigzag"
version = "1.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

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
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation(project(mapOf("path" to ":commons")))
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    implementation("org.springframework.boot:spring-boot-starter-graphql")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
    implementation("org.mapstruct:mapstruct:1.5.3.Final")
    kapt("org.mapstruct:mapstruct-processor:1.5.3.Final")
    //annotationProcessor("org.mapstruct:mapstruct-processor:1.5.3.Final")
    compileOnly("org.projectlombok:lombok:1.18.26")
    annotationProcessor("org.projectlombok:lombok:1.18.26")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
tasks.register("prepareKotlinBuildScriptModel") {}
tasks.getByName<BootJar>("bootJar") {
    mainClass.set("com.zigzag.crm.application.Application")
}
