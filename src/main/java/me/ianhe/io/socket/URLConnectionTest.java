package me.ianhe.io.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionTest {

    public static void main(String[] args) throws IOException {
//        URL url = new URL("https://itdage.com/kkb/kkbsms?key=xzk&number=18655591038&code=246200");
        URL url = new URL("https://api.apiopen.top/getJoke?count=1");

        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();

        byte[] bytes = new byte[1024];
        int readLength;
        while ((readLength = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, readLength));
        }
        inputStream.close();

    }
}
