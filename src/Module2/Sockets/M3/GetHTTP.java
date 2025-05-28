package Module2.Sockets.M3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

class GetHTTP {

     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         System.out.println("please enter the website name");
         String host = scanner.nextLine();

         URL url = null;
         HttpURLConnection connection;
         BufferedReader reader;
         try {
             url = new URL(host);
             connection = (HttpURLConnection) url.openConnection();
             reader = new BufferedReader(new InputStreamReader(url.openStream()));
             System.out.println("http- state: " + connection.getResponseCode());
             int lines = 10;
             String text;
             while (lines-- > 0 && reader.ready()) {
                 System.out.println(reader.readLine());
             }
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
     }
}
