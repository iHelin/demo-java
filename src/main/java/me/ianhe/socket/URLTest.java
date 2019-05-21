package me.ianhe.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author iHelin
 * @date 2019-05-20 15:44
 */
public class URLTest {

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.baidu.com");
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();

        byte[] temp = new byte[1024];
        int readLength;
        while ((readLength = inputStream.read(temp)) != -1) {
            System.out.println(new String(temp, 0, readLength));
        }
        inputStream.close();
    }
}
