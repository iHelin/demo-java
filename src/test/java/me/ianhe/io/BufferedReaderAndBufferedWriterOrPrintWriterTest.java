package me.ianhe.io;

import org.junit.Test;

import java.io.*;

/**
 * BufferedReader、BuferedWriter及PrintWriter测试
 *
 * @author iHelin
 * @since 2017/8/3 14:35
 */
public class BufferedReaderAndBufferedWriterOrPrintWriterTest {

    @Test
    public void testPrintWriter() throws Exception {
        FileInputStream fileInputStream = new FileInputStream("demo/demo.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        PrintWriter printWriter = new PrintWriter("demo/PrintWriter.txt");
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);// 一次读一行
            printWriter.println(line);
            printWriter.flush();
        }
        bufferedReader.close();
        printWriter.close();
    }

    @Test
    public void testBuffered() throws Exception {
        FileInputStream fileInputStream = new FileInputStream("demo/demo.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        FileOutputStream fileOutputStream = new FileOutputStream("demo/BufferedWriter.txt");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);// 一次读一行
            bufferedWriter.write(line); //单独写换行操作 bw.newLine();//换行操作 bw.flush();
            bufferedWriter.newLine();
        }
        bufferedReader.close();
        bufferedWriter.close();
    }

}