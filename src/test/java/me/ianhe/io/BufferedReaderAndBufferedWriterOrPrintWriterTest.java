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
        FileInputStream fis = new FileInputStream("demo/demo.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        PrintWriter pw = new PrintWriter("demo/PrintWriter.txt");
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);// 一次读一行
            pw.println(line);
            pw.flush();
        }
        br.close();
        pw.close();
    }

    @Test
    public void testBuffered() throws Exception {
        FileInputStream fis = new FileInputStream("demo/demo.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        FileOutputStream fos = new FileOutputStream("demo/BufferedWriter.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);// 一次读一行
            bw.write(line); //单独写换行操作 bw.newLine();//换行操作 bw.flush();
            bw.newLine();
        }
        br.close();
        bw.close();
    }

}