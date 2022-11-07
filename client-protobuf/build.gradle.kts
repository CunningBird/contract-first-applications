plugins {
    application
    id("java")
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

    // Web
    implementation("io.grpc:grpc-stub:1.49.2")
    implementation("io.grpc:grpc-okhttp:1.49.2")

    // DTO
    implementation("io.grpc:grpc-protobuf:1.49.2")
    implementation("com.cunningbird.contractfirst.protobuf:contract:1.0.0")
}