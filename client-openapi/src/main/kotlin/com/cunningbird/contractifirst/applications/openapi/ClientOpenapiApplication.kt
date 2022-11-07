package com.cunningbird.contractifirst.applications.openapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class ClientOpenapiApplication

fun main(args: Array<String>) {
    runApplication<ClientOpenapiApplication>(*args)
}
