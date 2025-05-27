package Module2.Sockets.M2;

import java.net.InetAddress;
import java.net.UnknownHostException;

class DNSLookups {

     public static void main(String[] args) throws UnknownHostException {

         InetAddress address = InetAddress.getByName("www.google.com");
         System.out.println("Hostname: " + address.getHostName());
         System.out.println("IP-address: " + address.getHostAddress());
         System.out.println("-------");

         InetAddress[] addresses = InetAddress.getAllByName("www.google.com");
         for (InetAddress adr : addresses) {
             System.out.println(adr.getHostAddress());
         }
     }
}
