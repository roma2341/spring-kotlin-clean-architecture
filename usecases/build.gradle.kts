plugins {
    id("java")
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("kapt")
}

group = "com.zigzag.crm"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:${rootProject.extra.get("junit_version")}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${rootProject.extra.get("junit_version")}")
    implementation(kotlin("stdlib", version = rootProject.extra.get("jetbrains_kotlin_version") as String))
    implementation("org.springframework:spring-context")
    implementation("org.mapstruct:mapstruct:1.5.2.Final")
    kapt("org.mapstruct:mapstruct-processor:1.5.2.Final")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    api(projects.domain)
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
