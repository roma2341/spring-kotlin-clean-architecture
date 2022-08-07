import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("java")
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("kapt")
}

group = "org.zigzag"
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
    api(projects.usecaseApi)
    api(projects.repositoryApi)
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
