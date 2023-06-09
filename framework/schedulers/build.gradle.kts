plugins {
    id("java")
    kotlin("jvm")
    kotlin("plugin.spring")
}

group = "org.experior"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(kotlin("stdlib"))
    implementation("org.springframework:spring-context")
    implementation(projects.domain)
    implementation(projects.usecases)
}

tasks.test {
    useJUnitPlatform()
}
