package com.cunningbird.contractfirst.protobuf.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ServerProtobufApplication

fun main(args: Array<String>) {
    runApplication<ServerProtobufApplication>(*args)
}
