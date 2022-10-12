package com.cunningbird.templates.contractfirstapplications.clientgrpc;

import com.cunningbird.templates.contractfirstgrpc.HelloRequest;
import com.cunningbird.templates.contractfirstgrpc.HelloResponse;
import com.cunningbird.templates.contractfirstgrpc.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Main {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);
        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                .setFirstName("Ricardo")
                .setLastName("Milos")
                .build());

        System.out.println(helloResponse.getGreeting());

        channel.shutdown();
    }
}