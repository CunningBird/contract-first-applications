plugins {
    id("org.springframework.boot") version "2.7.5"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
}

repositories {
    mavenLocal()
    mavenCentral()
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/cunningbird/contract-first-rest")
        credentials {
            username = System.getProperty("privateRegistryUsername")
            password = System.getProperty("privateRegistryPassword")
        }
    }
}

dependencies {
    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // Web
    implementation("org.springframework.boot:spring-boot-starter-web:2.7.5")
    implementation("org.springframework.data:spring-data-commons:2.7.3")

    // Contract
    implementation("com.cunningbird.templates:contract-first-rest:1.0.1")

    // SpringDoc dependencies
    implementation("org.springdoc:springdoc-openapi-webmvc-core:1.6.11")
    implementation("io.springfox:springfox-swagger2:2.9.2")

    // @Nullable annotation
    implementation("com.google.code.findbugs:jsr305:3.0.2")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.13.4")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.13.4")
    implementation("org.openapitools:jackson-databind-nullable:0.2.3")
}