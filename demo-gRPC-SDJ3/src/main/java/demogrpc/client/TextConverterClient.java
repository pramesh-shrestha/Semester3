package demogrpc.client;

import demogrpc.protobuf.Converter;
import demogrpc.protobuf.TextConverterGrpc;
import demogrpc.server.TextConverterService;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class TextConverterClient {
  public static void main(String[] args) {
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
        .usePlaintext()
        .build();

    TextConverterGrpc.TextConverterBlockingStub stub = TextConverterGrpc.newBlockingStub(channel);

    Converter.TextInput input = Converter.TextInput.newBuilder()
        .setInput("hey you")
        .build();

    Converter.TextInput input2 = Converter.TextInput.newBuilder()
        .setInput("hey you again")
        .build();

    Converter.TextOutput response = stub.toUpper(input);
    System.out.println("Received: " + response.getOutput());
    Converter.TextOutput response2 = stub.toUpper(input2);
    System.out.println("Received: " + response2.getOutput());

  }
}
