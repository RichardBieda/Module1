package Module2.Sockets.M1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class TCPServer {

     public static void main(String[] args) throws Exception{
         ServerSocket server = new ServerSocket(1234);
         System.out.println("TCP-Server is running on port " + server.getLocalPort());

         Socket client = server.accept();
         BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
         PrintWriter out = new PrintWriter(client.getOutputStream(), true);

         String line;
         while ((line = in.readLine()) != null) {
             System.out.println("received: " + line);
             out.println("Echo: " + line);
         }
         client.close();
         server.close();
     }
}
