package com.cunningbird.experimental.contractfirstapplications.servergrpc.service

import com.cunningbird.contractfirst.protobuf.contract.*
import io.grpc.stub.StreamObserver
import net.devh.boot.grpc.server.service.GrpcService

@GrpcService
class PetstoreServiceImpl : PetstoreServiceGrpc.PetstoreServiceImplBase() {

    override fun getPets(request: Empty, responseObserver: StreamObserver<Pets>) {
        val pet1 = Pet.newBuilder().setId(1).setName("Van").setTag("Cat").build()
        val pet2 = Pet.newBuilder().setId(2).setName("Billy").setTag("Cat").build()
        val response: Pets = Pets.newBuilder().addPets(pet1).addPets(pet2).build()
        responseObserver.onNext(response)
        responseObserver.onCompleted()
    }

    override fun getPetByID(request: PetID, responseObserver: StreamObserver<Pet>) {
        val response = Pet.newBuilder().setId(1).setName("Van").setTag("Cat").build()
        responseObserver.onNext(response)
        responseObserver.onCompleted()
    }

    override fun addPet(request: Pet, responseObserver: StreamObserver<Pet>) {
        val response = Pet.newBuilder().setId(1).setName("Van").setTag("Cat").build()
        responseObserver.onNext(response)
        responseObserver.onCompleted()
    }
}