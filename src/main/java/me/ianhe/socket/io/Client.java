package me.ianhe.socket.io;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Client
 *
 * @author iHelin
 * @since 2017/11/29 11:03
 */
public class Client {

    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 8000);
             OutputStream outputStream = socket.getOutputStream()) {

            //发送消息
            outputStream.write("Hello World".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
