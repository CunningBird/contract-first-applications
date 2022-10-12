package com.cunningbird.experimental.contractfirstapplications.clientrest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class ClientRestApplication

fun main(args: Array<String>) {
    runApplication<ClientRestApplication>(*args)
}
