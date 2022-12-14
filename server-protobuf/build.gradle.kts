plugins {
    id("org.springframework.boot") version "2.7.4"
    id("io.spring.dependency-management") version "1.0.14.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
}

repositories {
    mavenLocal()
    mavenCentral()
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/cunningbird/contract-first-protobuf")
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
    implementation("io.grpc:grpc-stub:1.49.0")
    implementation("net.devh:grpc-server-spring-boot-starter:2.13.1.RELEASE")

    // DTO
    implementation("io.grpc:grpc-protobuf:1.49.0")
    implementation("com.cunningbird.contractfirst.protobuf:contract:1.0.0")
}