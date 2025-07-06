package Module3.http;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

class UsingHttpClient {

    private static void synchronousExample() throws URISyntaxException {
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder(new URI("https://www.google.com"));
        HttpRequest request = requestBuilder.GET().header("User-Agent", "Java/App").build();

        System.out.println(request);

        try (HttpClient client =
                HttpClient.newBuilder()
                        .version(HttpClient.Version.HTTP_1_1)
                        .followRedirects(HttpClient.Redirect.NORMAL)
                        .build()) {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            System.out.println(response.headers() + "\n");
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    private static void asynchronousExample() throws URISyntaxException {
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder(new URI("https://www.google.com"));
        HttpRequest request = requestBuilder.GET().header("User-Agent", "Java/App").build();

        System.out.println(request);

        try (HttpClient client =
                     HttpClient.newBuilder()
                             .version(HttpClient.Version.HTTP_1_1)
                             .followRedirects(HttpClient.Redirect.NORMAL)
                             .build()) {
            CompletableFuture<HttpResponse<String>> future = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Not blocking just yet");

            // Fire and forget
            future.thenAccept(response -> {
                System.out.println(response.statusCode());
                System.out.println(response.headers() + "\n");
                System.out.println(response.body());
            });

            System.out.println("DONE");
        }
    }

    public static void main(String[] args) throws URISyntaxException {
        asynchronousExample();
    }
}
