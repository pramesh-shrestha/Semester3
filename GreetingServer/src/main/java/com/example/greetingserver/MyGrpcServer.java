package com.example.greetingserver;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class MyGrpcServer {
  public static void main(String[] args) throws IOException, InterruptedException {
    Server server = ServerBuilder.forPort(8080)
        .addService(new GrpcServiceImpl()) //dependency injection - registering the GrpcServiceImpl
        .build();
    server.start();
    System.out.println("Server started..");
    server.awaitTermination();
  }
}
