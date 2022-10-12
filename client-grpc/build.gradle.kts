plugins {
    application
    id("java")
}

group = "com.cunningbird.templates.contractfirstapplications"
version = "1.0.0"

repositories {
    mavenCentral()
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/cunningbird/contract-first-grpc")
        credentials {
            username = System.getProperty("privateRegistryUsername")
            password = System.getProperty("privateRegistryPassword")
        }
    }
}

dependencies {
    // Kotlin

    // Web
    implementation("io.grpc:grpc-stub:1.49.2")
    implementation("io.grpc:grpc-okhttp:1.49.2")

    // DTO
    implementation("io.grpc:grpc-protobuf:1.49.2")
    implementation("com.cunningbird.templates:contract-first-grpc:1.0.0")
}