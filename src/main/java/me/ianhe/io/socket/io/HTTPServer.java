package me.ianhe.io.socket.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * SimpleServer
 *
 * @author iHelin
 * @since 2017-03-29 22:09
 */
public class HTTPServer {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8000)) {

            int requestCount = 1;
            while (true) {
                try (Socket socket = serverSocket.accept();
                     InputStream inputStream = socket.getInputStream();
                     OutputStream outputStream = socket.getOutputStream()) {

                    BufferedReader bufferedReader = new BufferedReader(
                            new InputStreamReader(inputStream));
                    String line = bufferedReader.readLine();
                    while (line != null && !"".equals(line)) {
                        System.out.println(line);
                        line = bufferedReader.readLine();
                    }

                    System.out.println();

                    String sendString = "HTTP/1.1 200 OK\r\n" +
                            "Content-Type:text/html;charset=" + StandardCharsets.UTF_8.name() + "\r\n" +
                            "\r\n" +
                            "<html><head><title>OK</title></head><body>" +
                            "<h1>Count：" + (requestCount++) + "</h1>" +
                            "</body></html>";
                    outputStream.write(sendString.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
