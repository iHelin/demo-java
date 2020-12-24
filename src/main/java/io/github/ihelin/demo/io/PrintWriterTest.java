package io.github.ihelin.demo.io;

import java.io.*;

/**
 * @author iHelin
 * @date 2019-02-27 11:03
 */
public class PrintWriterTest {

    /**
     * 使用PrintWriter一次读一行
     *
     * @author iHelin
     * @since 2017/11/28 18:15
     */
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("demo/read.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        PrintWriter printWriter = new PrintWriter("demo/printWriter.txt");

        readByLine(bufferedReader, printWriter);
//        readByChars(bufferedReader, printWriter);

        fileInputStream.close();
        inputStreamReader.close();
        bufferedReader.close();
        printWriter.close();
    }

    /**
     * 一次读64个字符
     *
     * @param inputStreamReader
     * @param printWriter
     * @throws IOException
     */
    private static void readByChars(BufferedReader inputStreamReader, PrintWriter printWriter) throws IOException {
        char[] chars = new char[64];
        int count;
        while ((count = inputStreamReader.read(chars)) != -1) {
            printWriter.write(chars, 0, count);
            System.out.print(new String(chars, 0, count));
        }
    }

    /**
     * 一次读一行
     *
     * @param bufferedReader
     * @param printWriter
     * @throws IOException
     */
    private static void readByLine(BufferedReader bufferedReader, PrintWriter printWriter) throws IOException {
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
            printWriter.println(line);
        }
    }

}
