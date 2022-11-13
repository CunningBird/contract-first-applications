package com.cunningbird.contractfirst.openapi.server.controller

import com.cunningbird.contractfirst.openapi.contract.api.PetsApi
import com.cunningbird.contractfirst.openapi.contract.model.Pet
import com.cunningbird.contractfirst.openapi.server.service.PetsService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class PetsApiImpl(
    private val service: PetsService
) : PetsApi {

    override fun listPets(limit: Int): ResponseEntity<List<Pet>> {
        return ResponseEntity(service.getAllPetsWithLimit(limit), HttpStatus.OK)
    }

    override fun showPetById(petId: Long): ResponseEntity<Pet> {
        return try {
            ResponseEntity(service.getPetById(petId), HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    override fun createPet(pet: Pet): ResponseEntity<Void> {
        return ResponseEntity(HttpStatus.CREATED)
    }
}