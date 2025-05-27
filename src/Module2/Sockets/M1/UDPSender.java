package Module2.Sockets.M1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class UDPSender {

     public static void main(String[] args) throws Exception {
         DatagramSocket socket = new DatagramSocket();
         String message = "hi I'm a sender";
         byte[] data = message.getBytes();

         InetAddress receiverAddress = InetAddress.getByName("localHost");
         DatagramPacket packet = new DatagramPacket(data, data.length, receiverAddress, 1234);
         socket.send(packet);
         System.out.println("UDP packet send!");
         socket.close();
     }
}
