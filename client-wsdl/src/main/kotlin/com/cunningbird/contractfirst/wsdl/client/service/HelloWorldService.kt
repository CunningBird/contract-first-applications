package com.cunningbird.contractfirst.wsdl.client.service

import com.cunningbird.contractfirst.wsdl.contract.Greeting
import com.cunningbird.contractfirst.wsdl.contract.ObjectFactory
import com.cunningbird.contractfirst.wsdl.contract.Person
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.ws.client.core.WebServiceTemplate

@Service
class HelloWorldService(
    webServiceTemplate: WebServiceTemplate
) {

    private val LOGGER: Logger = LoggerFactory.getLogger(HelloWorldService::class.java)

    init {
        val factory = ObjectFactory()
        val person: Person = factory.createPerson()
        person.firstName = "Van"
        person.lastName = "Darkhomle"

        LOGGER.info("Client sending person[firstName={},lastName={}]", person.firstName, person.lastName)
        val greeting = webServiceTemplate.marshalSendAndReceive(person) as Greeting

        LOGGER.info("Client received greeting='{}'", greeting.greeting)
    }
}