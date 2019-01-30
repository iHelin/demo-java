package me.ianhe.io;

import org.junit.Test;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;

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
public class ReaderAndWriterTest {

    /**
     * 写入文件
     *
     * @author iHelin
     * @since 2017/11/27 18:07
     */
    @Test
    public void testOutputStreamWriter() throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("demo/outputStreamWriter.txt");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
        try {
            outputStreamWriter.write("这是要保存的中文字符");
        } finally {
            outputStreamWriter.close();
        }
    }

    /**
     * 从文件读
     *
     * @author iHelin
     * @since 2017/11/27 18:07
     */
    @Test
    public void testInputStreamReader() throws Exception {
        //读取字节转换成字符
        FileInputStream fileInputStream = new FileInputStream("demo/inputStreamReader.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
        StringBuffer stringBuffer = new StringBuffer();
        char[] chars = new char[64];
        int count;
        try {
            while ((count = inputStreamReader.read(chars)) > 0) {
                stringBuffer.append(chars, 0, count);
            }
        } finally {
            inputStreamReader.close();
        }
        System.out.println(stringBuffer.toString());
    }

    /**
     * 使用PrintWriter一次读一行
     *
     * @author iHelin
     * @since 2017/11/28 18:15
     */
    @Test
    public void testPrintWriterReadLine() throws Exception {
        FileInputStream fileInputStream = new FileInputStream("demo/read.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        PrintWriter printWriter = new PrintWriter("demo/printWriter.txt");
        String line;
        // 一次读一行
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
            printWriter.println(line);
        }
        bufferedReader.close();
        printWriter.close();
    }

    /**
     * 使用PrintWriter每次读64个字符
     *
     * @author iHelin
     * @since 2017/11/28 18:16
     */
    @Test
    public void testPrintWriterRead() throws Exception {
        FileInputStream fileInputStream = new FileInputStream("demo/read.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        PrintWriter printWriter = new PrintWriter("demo/printWriter.txt");
        char[] chars = new char[64];
        int count;
        while ((count = bufferedReader.read(chars)) != -1) {
            printWriter.write(chars, 0, count);
            System.out.print(new String(chars, 0, count));
        }
        bufferedReader.close();
        printWriter.close();
    }

    /**
     * 使用BufferedWriter每次读一行
     *
     * @author iHelin
     * @since 2017/11/28 18:19
     */
    @Test
    public void testBufferedWriterReadLine() throws Exception {
        FileInputStream fileInputStream = new FileInputStream("demo/read.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        FileOutputStream fileOutputStream = new FileOutputStream("demo/outputStreamWriter.txt");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        String line;
        // 一次读一行
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
            bufferedWriter.write(line);
            //单独写换行操作 bufferedWriter.newLine();
            bufferedWriter.newLine();
        }
        bufferedReader.close();
        bufferedWriter.close();
    }

    /**
     * 使用nio包下的CharBuffer
     *
     * @author iHelin
     * @since 2017/11/28 18:25
     */
    @Test
    public void testBufferedWriterReadCharBuffer() throws Exception {
        FileInputStream fileInputStream = new FileInputStream("demo/read.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        FileOutputStream fileOutputStream = new FileOutputStream("demo/outputStreamWriter.txt");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        int count;
        CharBuffer charBuffer = CharBuffer.allocate(1024);
        while ((count = bufferedReader.read(charBuffer)) != -1) {
            bufferedWriter.write(charBuffer.array(), 0, count);
        }
        bufferedReader.close();
        bufferedWriter.close();
    }

}