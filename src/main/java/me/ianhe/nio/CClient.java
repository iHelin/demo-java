package me.ianhe.nio;

import java.io.IOException;

/**
 * @author iHelin
 * @date 2019-05-06 23:54
 */
public class CClient {

    public static void main(String[] args) throws IOException {
        new NioClient().start("CClient");
    }
}
