package com.cunningbird.contractfirst.wsdl.server.endpoint;

import com.cunningbird.contractfirst.wsdl.contract.Greeting;
import com.cunningbird.contractfirst.wsdl.contract.ObjectFactory;
import com.cunningbird.contractfirst.wsdl.contract.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class HelloWorldEndpoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldEndpoint.class);

    @ResponsePayload
    @PayloadRoot(namespace = "http://localhost:8081/types/helloworld", localPart = "person")
    public Greeting sayHello(@RequestPayload Person request) {
        LOGGER.info("Endpoint received person[firstName={},lastName={}]", request.getFirstName(), request.getLastName());

        String greeting = "Hello " + request.getFirstName() + " " + request.getLastName() + "!";

        ObjectFactory factory = new ObjectFactory();
        Greeting response = factory.createGreeting();
        response.setGreeting(greeting);

        LOGGER.info("Endpoint sending greeting='{}'", response.getGreeting());
        return response;
    }
}