plugins {
    id("org.springframework.boot") version "2.7.0"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
}

repositories {
    mavenLocal()
    mavenCentral()
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/cunningbird/contract-first-openapi")
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
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")

    // Contract
    implementation("com.cunningbird.contractfirst.openapi:contract:1.0.0")

    // SpringDoc dependencies
    implementation("org.springdoc:springdoc-openapi-webmvc-core:1.6.11")
    implementation("io.springfox:springfox-swagger2:2.9.2")

    // @Nullable annotation
    implementation("com.google.code.findbugs:jsr305:3.0.2")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.13.4")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.13.4")
    implementation("org.openapitools:jackson-databind-nullable:0.2.3")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-starter-parent:2021.0.1")
    }
}