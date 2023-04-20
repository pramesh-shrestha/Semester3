package demogrpc.server;

import demogrpc.protobuf.Converter;
import demogrpc.protobuf.TextConverterGrpc;
import io.grpc.stub.StreamObserver;

public class TextConverterService extends TextConverterGrpc.TextConverterImplBase {
  @Override
  public void toUpper(Converter.TextInput request, StreamObserver<Converter.TextOutput> responseObserver) {
    System.out.println("Received request: " + request.toString());
    Converter.TextOutput output = Converter.TextOutput.newBuilder()
        .setOutput(request.getInput().toUpperCase())
        .build();

    responseObserver.onNext(output);
    responseObserver.onCompleted();
  }

  @Override
  public void toLower(Converter.TextInput request, StreamObserver<Converter.TextOutput> responseObserver) {
    System.out.println("Received request: " + request.toString());
    Converter.TextOutput output = Converter.TextOutput.newBuilder()
        .setOutput(request.getInput().toLowerCase())
        .build();
    responseObserver.onNext(output);
    responseObserver.onCompleted();
  }
}
