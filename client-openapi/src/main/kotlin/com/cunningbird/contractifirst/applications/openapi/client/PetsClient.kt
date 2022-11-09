package com.cunningbird.contractifirst.applications.openapi.client

import com.cunningbird.contractfirst.openapi.contract.api.PetsApi
import org.springframework.cloud.openfeign.FeignClient

@FeignClient(name = "pet", url = "http://localhost:8081")
interface PetsClient : PetsApi