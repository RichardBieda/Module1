package Module2.Sockets.M6;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

class TCPClient {

    public static void main(String[] args) {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress("localhost", 1234), 3000);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            socket.setSoTimeout(5000);

            Message message = new Message("hello server – object is comming!");
            out.writeObject(message);

            System.out.println("Message-object send.");
        } catch (SocketTimeoutException e) {
            System.out.println("error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}
