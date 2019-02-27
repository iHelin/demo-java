package me.ianhe.test;

import java.io.*;

/**
 * @author iHelin
 * @date 2019-02-27 11:20
 */
public class IOSupport {

    /**
     * 对应英文字母“abcddefghijklmnopqrsttuvwxyz”
     */
    public static final byte[] ARRAY_LETTERS = {
            0x61, 0x62, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68, 0x69, 0x6A, 0x6B, 0x6C, 0x6D,
            0x6E, 0x6F, 0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78, 0x79, 0x7A};

    /**
     * 打印byte对应的16进制的字符串
     *
     * @param val
     * @return
     */
    public static String byteToHexString(byte val) {
        return Integer.toHexString(val & 0xff);
    }

    /**
     * 打印char对应的16进制的字符串
     *
     * @param val
     * @return
     */
    public static String charToHexString(char val) {
        return Integer.toHexString(val);
    }

    /**
     * 打印short对应的16进制的字符串
     *
     * @param val
     * @return
     */
    public static String shortToHexString(short val) {
        return Integer.toHexString(val & 0xffff);
    }

    public static BufferedReader getBufferedReader() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("demo/read.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        return new BufferedReader(inputStreamReader);
    }

    public static BufferedWriter getBufferedWriter() {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("demo/outputStreamWriter.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        return new BufferedWriter(outputStreamWriter);
    }
}
