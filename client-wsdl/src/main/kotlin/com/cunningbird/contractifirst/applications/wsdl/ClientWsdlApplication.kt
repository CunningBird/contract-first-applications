package com.cunningbird.contractifirst.applications.wsdl

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ClientWsdlApplication

fun main(args: Array<String>) {
    runApplication<ClientWsdlApplication>(*args)
}
