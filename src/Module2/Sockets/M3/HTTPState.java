package Module2.Sockets.M3;

import java.net.HttpURLConnection;
import java.net.URL;

class HTTPState {

    public static void main(String[] args) throws Exception {
        URL url = new URL("https://www.google.com/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        int state = connection.getResponseCode();
        System.out.println("http- state: " + state);
    }
}
