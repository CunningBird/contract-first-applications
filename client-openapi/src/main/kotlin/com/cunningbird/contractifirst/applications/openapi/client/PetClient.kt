package com.cunningbird.contractifirst.applications.openapi.client

import com.cunningbird.templates.contractfirstrest.api.PetsApi
import org.springframework.cloud.openfeign.FeignClient

@FeignClient(name = "pet", url = "http://localhost:8081")
interface PetClient : PetsApi