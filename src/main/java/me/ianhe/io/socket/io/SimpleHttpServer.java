package me.ianhe.io.socket.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * SimpleHTTPServer
 *
 * @author iHelin
 * @since 2017-03-29 22:09
 */
public class SimpleHttpServer {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8000)) {

            int requestCount = 1;
            while (true) {
                try (Socket socket = serverSocket.accept();
                     InputStream inputStream = socket.getInputStream();
                     OutputStream outputStream = socket.getOutputStream()) {

                    byte[] bytes = new byte[8192];
                    int readLength = inputStream.read(bytes);

                    while (readLength >= bytes.length) {
                        System.out.print(new String(bytes, 0, readLength));
                        readLength = inputStream.read(bytes);
                    }

                    System.out.print(new String(bytes, 0, readLength));

                    System.out.println();

                    String responseString = "HTTP/1.1 200 OK\r\n" +
                            "Content-Type:application/json;charset=utf-8\r\n" +
                            "\r\n" +
                            "{\"count\":" + (requestCount++) + "}";
                    outputStream.write(responseString.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (BindException e) {
            System.out.println("port ++");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}