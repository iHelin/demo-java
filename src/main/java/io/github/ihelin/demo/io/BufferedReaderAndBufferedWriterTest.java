package io.github.ihelin.demo.io;

import io.github.ihelin.demo.utils.IOSupport;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * @author iHelin
 * @date 2019-02-27 11:13
 */
public class BufferedReaderAndBufferedWriterTest {

    /**
     * 使用BufferedWriter每次读一行
     *
     * @author iHelin
     * @since 2017/11/28 18:19
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = IOSupport.getBufferedReader();
        BufferedWriter bufferedWriter = IOSupport.getBufferedWriter();

        String line;
        // 一次读一行
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
            bufferedWriter.write(line);
            //单独写换行操作
            bufferedWriter.newLine();
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
