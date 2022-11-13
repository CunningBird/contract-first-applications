package com.cunningbird.contractfirst.openapi.client.service

import com.cunningbird.contractfirst.openapi.contract.model.Pet
import com.cunningbird.contractfirst.openapi.client.client.PetsClient
import org.springframework.stereotype.Service

@Service
class PetsService(client: PetsClient) {

    init {
        val getPetsResponse = client.listPets(2)
        try {
            val pets = getPetsResponse.body ?: throw Exception("Occurred error while listPets query. Status code: ${getPetsResponse.statusCode}")
            pets.forEachIndexed { index, pet ->
                println("Pet[${index}]: id - ${pet.id}, name - ${pet.name}, tag - ${pet.tag}")
            }
        } catch (e: Exception) {
            println(e.message)
        }

        val findPetByIdResponse = client.showPetById(1)
        try {
            val pet = findPetByIdResponse.body ?: throw Exception("Occurred error while showPetById query. Status code: ${findPetByIdResponse.statusCode}")
            println("Specific Pet: id - ${pet.id}, name - ${pet.name}, tag - ${pet.tag}")
        } catch (e: Exception) {
            println(e.message)
        }

        val createPetResponse = client.createPet(
            Pet().apply {
                id = 3
                name = "Van"
                tag = "cat"
            }
        )
        try {
            createPetResponse.body ?: throw Exception("Occurred error while showPetById query. Status code: ${createPetResponse.statusCode}")
            println("Pet created")
        } catch (e: Exception) {
            println(e.message)
        }
    }
}