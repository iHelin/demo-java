package me.ianhe.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionTest {

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://itdage.com/kkb/kkbsms?key=xzk&number=18655591038&code=246200");

        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();

//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//        String line = bufferedReader.readLine();
//        System.out.println(line);
        byte[] temp = new byte[1024];
        int readLength;
        while ((readLength = inputStream.read(temp)) != -1) {
            System.out.println(new String(temp, 0, readLength));
        }
        inputStream.close();

    }
}
