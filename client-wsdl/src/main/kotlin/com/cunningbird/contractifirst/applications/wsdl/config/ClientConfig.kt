package com.cunningbird.contractifirst.applications.wsdl.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.oxm.jaxb.Jaxb2Marshaller
import org.springframework.ws.client.core.WebServiceTemplate


@Configuration
class ClientConfig {
    @Bean
    fun jaxb2Marshaller(): Jaxb2Marshaller {
        val jaxb2Marshaller = Jaxb2Marshaller()
        jaxb2Marshaller.contextPath = "com.cunningbird.contractfirst.wsdl.contract"
        return jaxb2Marshaller
    }

    @Bean
    fun webServiceTemplate(): WebServiceTemplate {
        val webServiceTemplate = WebServiceTemplate()
        webServiceTemplate.marshaller = jaxb2Marshaller()
        webServiceTemplate.unmarshaller = jaxb2Marshaller()
        webServiceTemplate.defaultUri = "http://localhost:8080/codenotfound/ws/helloworld"
        return webServiceTemplate
    }
}