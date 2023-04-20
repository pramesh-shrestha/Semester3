import java.io.IOException;
import java.net.*;

public class MulticastReceiver extends Thread {
  protected MulticastSocket socket = null;
  protected byte[] buf = new byte[256];

  public void run() {
    try {
      socket = new MulticastSocket(4446);
      InetAddress group = InetAddress.getByName("230.0.0.0");
      InetSocketAddress socketAddress = new InetSocketAddress(group, 4446);
      NetworkInterface netIf = NetworkInterface.getByName("team40");

      socket.joinGroup(socketAddress, netIf);
      while (true) {
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);
        String received = new String(packet.getData(), 0, packet.getLength());
        if ("end".equals(received)) {
          break;
        }
      }
      socket.leaveGroup(socketAddress, netIf);
      socket.close();
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}


