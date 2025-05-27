package Module2.Sockets.M2;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

class GetIPs {

     public static void main(String[] args) {

         Scanner scanner = new Scanner(System.in);
         System.out.println("enter hostname");
         String host = scanner.nextLine();

         InetAddress[] addresses;
         try {
             addresses = InetAddress.getAllByName(host);
         } catch (UnknownHostException e) {
             throw new RuntimeException(e);
         }

         for (InetAddress adr : addresses) {
             System.out.println("Hostname: " + adr.getHostName());
             System.out.println("IP- address: " + adr.getHostAddress());
         }
     }
}
