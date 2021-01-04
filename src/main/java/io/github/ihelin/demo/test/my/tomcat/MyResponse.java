package io.github.ihelin.demo.test.my.tomcat;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author iHelin
 * @since 2017/8/18 13:24
 */
public class MyResponse {

    private final OutputStream outputStream;

    public MyResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void write(String content) throws IOException {
        String httpResponse = "HTTP/1.1 200 OK\n" +
                "Content-Type: text/html\n" +
                "\r\n" +
                "<html><body>" +
                content +
                "</body></html>";
        outputStream.write(httpResponse.getBytes());
        outputStream.close();
    }
}
