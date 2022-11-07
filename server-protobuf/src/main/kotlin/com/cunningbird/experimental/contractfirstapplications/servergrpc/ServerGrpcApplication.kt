package com.cunningbird.experimental.contractfirstapplications.servergrpc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ServerGrpcApplication

fun main(args: Array<String>) {
    runApplication<ServerGrpcApplication>(*args)
}
