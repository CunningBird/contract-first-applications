package com.cunningbird.contractfirst.graphqls.client.client

import com.cunningbird.contractfirst.graphqls.contract.model.Pet
import org.springframework.graphql.client.HttpGraphQlClient
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient


@Component
class PetstoreClient {

    private val graphQlClient = HttpGraphQlClient.builder(WebClient.create("http://localhost:8082/graphql")).build()

    init {
        val document = "query getPetById(\$petId: ID!) {" +
                "    pet(id: \$petId) {" +
                "        id" +
                "        name" +
                "        tag" +
                "    }" +
                "}"

        val result = graphQlClient.document(document)
            .variable("petId", 2)
            .retrieve("pet")
            .toEntity(Pet::class.java)
            .subscribe {
                println("Flex")
            }
    }
}