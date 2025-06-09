package Module2.Sockets.M6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class TCPServer {

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(1234)) {
            System.out.println("waiting for client...");
            Socket client = server.accept();
            System.out.println("Client connected.");

            ObjectInputStream in = new ObjectInputStream(client.getInputStream());
            Message nachricht = (Message) in.readObject();

            System.out.println("received: " + nachricht.getText());

            client.close();
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}
