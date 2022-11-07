package com.cunningbird.contractfirst.graphqls.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ServerGraphqlApplication

fun main(args: Array<String>) {
    runApplication<ServerGraphqlApplication>(*args)
}
