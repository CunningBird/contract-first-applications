package com.cunningbird.contractfirst.wsdl.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ServerWsdlApplication

fun main(args: Array<String>) {
    runApplication<ServerWsdlApplication>(*args)
}
