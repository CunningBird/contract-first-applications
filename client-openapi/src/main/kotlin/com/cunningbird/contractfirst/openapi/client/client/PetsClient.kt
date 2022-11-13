package com.cunningbird.contractfirst.openapi.client.client

import com.cunningbird.contractfirst.openapi.contract.api.PetsApi
import org.springframework.cloud.openfeign.FeignClient

@FeignClient(name = "pet", url = "http://localhost:8083")
interface PetsClient : PetsApi