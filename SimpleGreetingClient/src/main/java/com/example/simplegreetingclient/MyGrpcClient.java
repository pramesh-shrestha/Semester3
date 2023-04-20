package com.example.simplegreetingclient;


import com.example.grpc.GreetingServiceGrpc;
import com.example.grpc.HelloRequest;
import com.example.grpc.HelloResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class MyGrpcClient {
  public static void main(String[] args) {
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
        .usePlaintext()
        .build();

    //Generating stub
    GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);

    HelloResponse response = stub.greeting(
        HelloRequest.newBuilder().setFirstname("Pramesh").setAge(17).addHobbies("coding")
            .addHobbies("gaming").putBagOfTricks("dotnet", "coding").build());

    System.out.println(response);

  }
}
