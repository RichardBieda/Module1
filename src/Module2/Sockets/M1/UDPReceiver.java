package Module2.Sockets.M1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

class UDPReceiver {

     public static void main(String[] args) throws Exception {
         DatagramSocket socket = new DatagramSocket(1234);
         byte[] buffer = new byte[1024];
         System.out.println("UDP receiver is running on port " + socket.getLocalPort());

         DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
         socket.receive(packet);

         String received = new String(packet.getData(), 0, packet.getLength());
         System.out.println("received: " + received);
         socket.close();
     }
}
