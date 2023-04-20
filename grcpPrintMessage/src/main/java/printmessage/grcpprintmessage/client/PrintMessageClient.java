package printmessage.grcpprintmessage.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import printmessage.grcpprintmessage.protobuf.MessageGrpc;
import printmessage.grcpprintmessage.protobuf.Schema;

import java.util.Scanner;

public class PrintMessageClient {
  public static void main(String[] args) {
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",8080)
        .usePlaintext()
        .build();

    MessageGrpc.MessageBlockingStub stub = MessageGrpc.newBlockingStub(channel);

    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("Write your message >");
      String msg = scanner.nextLine();
      Schema.TextInput input = Schema.TextInput.newBuilder()
          .setMessage(msg)
          .build();

      Schema.TextOutput output = stub.printMessage(input);
      for (int i = 0; i < output.getMessagesCount(); i++) {
        System.out.println(output.getMessages(i));
      }
    }
  }


}
