package com.cunningbird.contractifirst.applications.openapi.service

import com.cunningbird.templates.contractfirstrest.api.PetsApi
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class PetsService(client: PetsApi) {

    init {
        val petsResponse = client.listPets(2)
        try {
            val pets = petsResponse.body ?: throw Exception("Occurred error while listPets query. Status code: ${petsResponse.statusCode}")
            pets.forEachIndexed { index, pet ->
                println("Pet[${index}]: id - ${pet.id}, name - ${pet.name}, tag - ${pet.tag}")
            }
        } catch (e: Exception) {
            println(e.message)
        }

        val petResponse = client.showPetById(1)
        try {
            val pet = petResponse.body ?: throw Exception("Occurred error while showPetById query. Status code: ${petResponse.statusCode}")
            println("Specific Pet: id - ${pet.id}, name - ${pet.name}, tag - ${pet.tag}")
        } catch (e: Exception) {
            println(e.message)
        }
    }
}