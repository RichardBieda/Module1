package Module2.Sockets.M4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class MultiClientServer {

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        try {
            serverSocket = new ServerSocket(1234);
            System.out.println("Server is running on port: " + serverSocket.getLocalPort());

            while (true) {
                clientSocket = serverSocket.accept();
                System.out.println("new client connected");
                clientSocket.getInetAddress();
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                serverSocket.close();
                clientSocket.close();
            } catch (IOException | NullPointerException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class ClientHandler extends Thread {
        private Socket client;

        ClientHandler(Socket socket) {
            this.client = socket;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream())); PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {
                String input;
                while ((input = in.readLine()) != null) {
                    System.out.println("input from client: " + client.getInetAddress()+ ": " + input);
                    out.println("echo: " + input);
                    if (input.equalsIgnoreCase("exit")) break;
                }
                client.close();
                System.out.println("client lost: " + client.getInetAddress());
            } catch (IOException e) {
                System.err.println("error at client: " + client.getInetAddress() + ": " + e.getMessage());
            }
        }
    }
}
