package com.cunningbird.contractfirst.graphqls.server.service

import com.cunningbird.contractfirst.graphqls.contract.model.InputPet
import com.cunningbird.contractfirst.graphqls.contract.model.Pet
import org.springframework.stereotype.Service

@Service
class PetsService {

    private var pets: MutableList<Pet> = mutableListOf(
        Pet().apply {
            id = 1
            name = "Ricardo"
            tag = "cats"
        },
        Pet().apply {
            id = 2
            name = "Billy"
            tag = "cats"
        },
        Pet().apply {
            id = 3
            name = "Rax"
            tag = "dogs"
        }
    )

    fun getAllPets(): MutableList<Pet> {
        return pets
    }

    fun getPetById(id: Long): Pet {
        val pet = pets.find {
            it.id == id
        }
        return pet ?: throw Exception("Pet not found")
    }

    fun getPet(req: InputPet): Pet {
        val pet = Pet().apply {
            id = req.id
            name = req.name
            tag = req.tag
        }
        pets.add(pet)
        return pet
    }
}