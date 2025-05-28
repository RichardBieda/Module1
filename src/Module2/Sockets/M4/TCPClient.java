package Module2.Sockets.M4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class TCPClient {

     public static void main(String[] args) {

         try (Socket socket = new Socket("localHost", 1234); PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
              BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); Scanner scanner = new Scanner(System.in)) {

             while (true) {
                 System.out.print(">");
                 String input = scanner.nextLine();
                 out.println(input);
                 if (input.equalsIgnoreCase("exit")) break;

                 String response = in.readLine();
                 System.out.println("server: " + response);
             }
             System.out.println("connection lost");
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
     }
}
