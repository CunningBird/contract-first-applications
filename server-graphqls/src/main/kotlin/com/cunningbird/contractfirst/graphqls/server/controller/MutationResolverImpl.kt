package com.cunningbird.contractfirst.graphqls.server.controller

import com.cunningbird.contractfirst.graphqls.contract.api.MutationResolver
import com.cunningbird.contractfirst.graphqls.contract.model.InputPet
import com.cunningbird.contractfirst.graphqls.contract.model.Pet
import com.cunningbird.contractfirst.graphqls.server.service.PetsService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.stereotype.Controller

@Controller
class MutationResolverImpl(
    private val service: PetsService
) : MutationResolver {

    @MutationMapping
    override fun addPet(@Argument pet: InputPet): Pet {
        return service.getPet(pet)
    }
}