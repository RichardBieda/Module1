package Module2.Sockets.M5;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class UDPSender {

     public static void main(String[] args) throws Exception {
         DatagramSocket socket = new DatagramSocket();
         String nachricht = "Hello UDP-receiver!";
         byte[] data = nachricht.getBytes();

         InetAddress receiver = InetAddress.getByName("localhost");
         DatagramPacket packet = new DatagramPacket(data, data.length, receiver, 1234);
         socket.send(packet);

         System.out.println("UDP-Paket gesendet.");
         socket.close();
     }
}
