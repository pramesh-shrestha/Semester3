package printmessage.grcpprintmessage.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class StartServer {
  public static void main(String[] args) throws IOException, InterruptedException {
    Server server = ServerBuilder.forPort(8080).addService(new PrintMessageService()).build();
    server.start();
    System.out.println("Server started..");
    server.awaitTermination();
  }
}
