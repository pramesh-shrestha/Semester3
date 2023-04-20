import com.google.gson.Gson;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
      Socket socket = new Socket("127.0.0.1", 2910);

      // Send to server
      OutputStream outputStream = socket.getOutputStream();
      Gson gson = new Gson();
      User user = new User("Pramesh", "Shrestha");
      String json = gson.toJson(user);
      System.out.println(json);


      byte[] responseAsBytes = json.getBytes();
      outputStream.write(responseAsBytes, 0, responseAsBytes.length);
      socket.close();
    }
}
