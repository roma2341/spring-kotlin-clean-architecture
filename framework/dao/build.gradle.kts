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
    maven { url = uri("https://repo.spring.io/milestone") }
    maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    implementation(kotlin("stdlib"))
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
