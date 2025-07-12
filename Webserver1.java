import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Webserver1 {
    public static void main(String[] args) {
        try {
            HttpServer httpServer = HttpServer.create(new InetSocketAddress(3001), 0);

            httpServer.createContext("/", new HttpHandler() {
                @Override
                public void handle(HttpExchange httpExchange) throws IOException {
                    String response = "<h1> This is my small implementation of a Java web server.</h1>";

                    httpExchange.sendResponseHeaders(200, response.length());

                    OutputStream os = httpExchange.getResponseBody();
                    os.write(response.getBytes());
                    os.close();
                }
            });
            httpServer.createContext("/guidehouse", new HttpHandler() {
                @Override
                public void handle(HttpExchange httpExchange) throws IOException {
                    java.nio.file.Path filePath = java.nio.file.Paths.get("guidehouse.html");
                    if (java.nio.file.Files.exists(filePath)) {
                        byte[] fileBytes = java.nio.file.Files.readAllBytes(filePath);
                        httpExchange.getResponseHeaders().add("Content-Type", "text/html");
                        httpExchange.sendResponseHeaders(200, fileBytes.length);
                        OutputStream os = httpExchange.getResponseBody();
                        os.write(fileBytes);
                        os.close();
                    } else {
                        String notFound = "File not found";
                        httpExchange.sendResponseHeaders(404, notFound.length());
                        OutputStream os = httpExchange.getResponseBody();
                        os.write(notFound.getBytes());
                        os.close();
                    }
                }
            });

            httpServer.start();
            System.out.println("Server started on port 3001");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

