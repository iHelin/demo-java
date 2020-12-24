package io.github.ihelin.demo.io;

import io.github.ihelin.demo.utils.IOSupport;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.CharBuffer;

/**
 * 字符流测试
 * InputStreamReader
 * OutputStreamWriter
 * BufferedReader
 * BufferedWriter
 * PrintWriter
 *
 * @author iHelin
 * @since 2017/8/3 14:35
 */
public class CharBufferTest {

    /**
     * 使用nio包下的CharBuffer
     *
     * @author iHelin
     * @since 2017/11/28 18:25
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = IOSupport.getBufferedReader();
        BufferedWriter bufferedWriter = IOSupport.getBufferedWriter();

        int count;
        CharBuffer charBuffer = CharBuffer.allocate(1024);
        while ((count = bufferedReader.read(charBuffer)) != -1) {
            System.out.println(new String(charBuffer.array(), 0, count));
            bufferedWriter.write(charBuffer.array(), 0, count);
        }
    }

}