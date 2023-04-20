package printmessage.grcpprintmessage.server;

import io.grpc.stub.StreamObserver;
import printmessage.grcpprintmessage.protobuf.MessageGrpc;
import printmessage.grcpprintmessage.protobuf.Schema;

public class PrintMessageService extends MessageGrpc.MessageImplBase{

  @Override
  public void printMessage(Schema.TextInput request, StreamObserver<Schema.TextOutput> responseObserver) {
    responseObserver.onNext(Schema.TextOutput.newBuilder()
            .addMessages(request.getMessage())
        .build());
    responseObserver.onCompleted();
    System.out.println(request.getMessage());
  }

}
