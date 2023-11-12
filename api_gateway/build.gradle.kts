plugins {
    id("java")
    kotlin("jvm")
    kotlin("kapt")
}

group = "com.zigzag.crm"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(enforcedPlatform("org.springframework.cloud:spring-cloud-dependencies:${rootProject.extra.get("spring_cloud_version")}"))
    implementation("org.springframework.cloud:spring-cloud-config-client")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
    implementation("org.springframework.cloud:spring-cloud-starter-gateway")
    compileOnly("org.springframework.boot:spring-boot-devtools")
}

tasks.test {
    useJUnitPlatform()
}
