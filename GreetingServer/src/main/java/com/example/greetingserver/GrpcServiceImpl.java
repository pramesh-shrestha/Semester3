package com.example.greetingserver;

import com.example.grpc.GreetingServiceGrpc;
import com.example.grpc.HelloRequest;
import com.example.grpc.HelloResponse;
import io.grpc.stub.StreamObserver;

public class GrpcServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {
  @Override
  public void greeting(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
      responseObserver.onNext(HelloResponse.newBuilder()
              .setGreeting("Hello " + request.getFirstname() + " " + request.getLastname())
          .build());
      responseObserver.onCompleted();
  }
}
