package com.cunningbird.contractifirst.applications.protobuf;

import com.cunningbird.contractfirst.protobuf.contract.*;
import com.google.common.util.concurrent.ListenableFuture;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Main {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        PetstoreServiceGrpc.PetstoreServiceFutureStub client = PetstoreServiceGrpc.newFutureStub(channel);

        Empty request1 = Empty.newBuilder().build();
        PetID request2 = PetID.newBuilder().setId(1).build();
        Pet request3 = Pet.newBuilder().setId(1).setName("Van").setTag("Cat").build();

        ListenableFuture<Pets> response1 = client.getPets(request1);
        ListenableFuture<Pet> response2 = client.getPetByID(request2);
        ListenableFuture<Pet> response3 = client.addPet(request3);

        System.out.println(response1);
        System.out.println(response2);
        System.out.println(response3);

        channel.shutdown();
    }
}