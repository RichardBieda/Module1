package Module2.Sockets.M4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class TCPEchoServer {

     public static void main(String[] args) {

         ServerSocket serverSocket = null;
         Socket clientSocket = null;
         try {
             serverSocket = new ServerSocket(1234);
             System.out.println("Server is running on port: " + serverSocket.getLocalPort());

             clientSocket = serverSocket.accept();
             System.out.println("client connected");

             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

             String input;
             while ((input = in.readLine()) != null) {
                 System.out.println("received: " + input);
                 out.println("Echo: " + input);
             }
         } catch (IOException e) {
             throw new RuntimeException(e);
         } finally {
             try {
                 serverSocket.close();
                 clientSocket.close();
             } catch (IOException e) {
                 throw new RuntimeException(e);
             }
         }
     }
}
