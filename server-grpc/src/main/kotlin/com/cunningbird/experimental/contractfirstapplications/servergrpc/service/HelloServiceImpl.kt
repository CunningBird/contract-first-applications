package com.cunningbird.experimental.contractfirstapplications.servergrpc.service

import com.cunningbird.templates.contractfirstgrpc.HelloRequest
import com.cunningbird.templates.contractfirstgrpc.HelloResponse
import com.cunningbird.templates.contractfirstgrpc.HelloServiceGrpc
import io.grpc.stub.StreamObserver
import net.devh.boot.grpc.server.service.GrpcService

@GrpcService
class HelloServiceImpl : HelloServiceGrpc.HelloServiceImplBase() {

    override fun hello(request: HelloRequest, responseObserver: StreamObserver<HelloResponse>) {
        val greeting = StringBuilder()
            .append("Hello, ")
            .append(request.firstName)
            .append(" ")
            .append(request.lastName)
            .toString()

        println("Generated message for client: $greeting")

        val response = HelloResponse.newBuilder()
            .setGreeting(greeting)
            .build()

        responseObserver.onNext(response)
        responseObserver.onCompleted()
    }
}