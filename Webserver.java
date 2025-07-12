import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Webserver {
    public static void main(String[] args) {
        try {
            // 1. Create an HTTP server listening on port 8080
            HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);

            // 2. Create a context (route) for "/"
            httpServer.createContext("/", new HttpHandler() {
                @Override
                public void handle(HttpExchange httpExchange) throws IOException {
                    // 3. Set response message
                    String response = "<h1>Hello World. This is my small implementation of a Java web server.</h1>";

                    // 4. Send HTTP status and length
                    httpExchange.sendResponseHeaders(200, response.length());

                    // 5. Write response to the output stream
                    OutputStream os = httpExchange.getResponseBody();
                    os.write(response.getBytes());
                    os.close();
                }
            });

            // 6. Start the server
            httpServer.start();
            System.out.println("Server started on port 8080");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
