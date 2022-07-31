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
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    implementation(kotlin("stdlib"))
    api(projects.framework.controllers)
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
