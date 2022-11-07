package com.cunningbird.experimental.contractfirstapplications.serverrest.controller

import com.cunningbird.experimental.contractfirstapplications.serverrest.service.PetsService
import com.cunningbird.templates.contractfirstrest.api.PetsApi
import com.cunningbird.templates.contractfirstrest.model.Pet
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
}