plugins {
    id("java")
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
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
