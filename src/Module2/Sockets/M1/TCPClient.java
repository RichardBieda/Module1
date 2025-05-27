package Module2.Sockets.M1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class TCPClient {

     public static void main(String[] args) throws Exception {
         Socket socket = new Socket("localHost", 1234);
         PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

         BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         out.println("hi I'm a client");

         System.out.println("Response: " + in.readLine());
         socket.close();
     }
}
