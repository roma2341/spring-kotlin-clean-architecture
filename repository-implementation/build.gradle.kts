plugins {
    id("java")
    kotlin("jvm")
    kotlin("plugin.spring")
}

group = "org.zigzag"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    implementation(kotlin("stdlib"))
    implementation("org.springframework:spring-context")
    api(projects.repositoryApi)
    implementation("org.springframework.boot:spring-boot-starter-webflux")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
