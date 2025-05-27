package Module2.Sockets.M1;

import java.net.InetAddress;
import java.net.UnknownHostException;

class MyNetworkInfo {

    public static void main(String[] args) {
        try {
            InetAddress local = InetAddress.getLocalHost();
            System.out.println("HostName: " + local.getHostName() + "\nIP-Address: " + local.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("something went wrong");
            throw new RuntimeException(e);
        }
    }
}
