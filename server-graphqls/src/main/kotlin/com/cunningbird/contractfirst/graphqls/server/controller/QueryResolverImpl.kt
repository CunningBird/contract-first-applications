package com.cunningbird.contractfirst.graphqls.server.controller

import com.cunningbird.contractfirst.graphqls.contract.api.QueryResolver
import com.cunningbird.contractfirst.graphqls.contract.model.Pet
import com.cunningbird.contractfirst.graphqls.server.service.PetsService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Component
import org.springframework.stereotype.Controller

@Controller
class QueryResolverImpl(
    private val service: PetsService
) : QueryResolver {

    @QueryMapping
    override fun pets(): MutableList<Pet> {
        return service.getAllPets()
    }

    @QueryMapping
    override fun pet(@Argument id: Long): Pet {
        return service.getPetById(id)
    }
}