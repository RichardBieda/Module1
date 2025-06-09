package Module2.Sockets.M7;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

class HTTPSCall {

    public static void main(String[] args) throws Exception {
        URL url = new URL("https://www.google.com");
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        int status = connection.getResponseCode();
        System.out.println("Statuscode: " + status);

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
        connection.disconnect();
    }
}
