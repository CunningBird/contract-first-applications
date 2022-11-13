package com.cunningbird.contractfirst.openapi.server.service

import com.cunningbird.contractfirst.openapi.contract.model.Pet
import org.springframework.stereotype.Service

@Service
class PetsService {

    private var pets: MutableList<Pet> = mutableListOf()

    init {
        pets.add(Pet().apply {
            id = 1
            name = "Ricardo"
            tag = "cats"
        })
        pets.add(Pet().apply {
            id = 1
            name = "Billy"
            tag = "cats"
        })
        pets.add(Pet().apply {
            id = 1
            name = "Rax"
            tag = "dogs"
        })
    }

    fun getAllPetsWithLimit(limit: Int): List<Pet> {
        return pets.take(limit)
    }

    fun getPetById(id: Long): Pet {
        val pet = pets.find {
            it.id == id
        }
        return pet ?: throw Exception("Pet not found")
    }
}