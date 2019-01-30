package me.ianhe.io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * DataInputStream
 * DataInputStream 是数据输入流。它继承于FilterInputStream。
 * DataInputStream 是用来装饰其它输入流，它“允许应用程序以与机器无关方式从底层输入流中读取基本 Java 数据类型”。
 * 应用程序可以使用DataOutputStream(数据输出流)写入由DataInputStream(数据输入流)读取的数据。
 *
 * @author iHelin
 * @since 2017/8/3 14:53
 */
public class DataInputStreamTest {

    public static void main(String[] args) {
        try {
            DataInputStream dataInputStream = new DataInputStream(
                    new FileInputStream("demo/data.txt"));
            System.out.printf("byteToHexString(0x8F):0x%s\n", byteToHexString((byte) 0x8F));
            System.out.printf("charToHexString(0x8FCF):0x%s\n", charToHexString((char) 0x8FCF));
            System.out.printf("readBoolean():%s\n", dataInputStream.readBoolean());
            System.out.printf("readByte():0x%s\n", byteToHexString(dataInputStream.readByte()));
            System.out.printf("readChar():0x%s\n", charToHexString(dataInputStream.readChar()));
            System.out.printf("readShort():0x%s\n", shortToHexString(dataInputStream.readShort()));
            System.out.printf("readInt():0x%s\n", Integer.toHexString(dataInputStream.readInt()));
            System.out.printf("readLong():0x%s\n", Long.toHexString(dataInputStream.readLong()));
            System.out.printf("readUTF():%s\n", dataInputStream.readUTF());
            dataInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 打印byte对应的16进制的字符串
     *
     * @param val
     * @return
     */
    private static String byteToHexString(byte val) {
        return Integer.toHexString(val & 0xff);
    }

    /**
     * 打印char对应的16进制的字符串
     *
     * @param val
     * @return
     */
    private static String charToHexString(char val) {
        return Integer.toHexString(val);
    }

    /**
     * 打印short对应的16进制的字符串
     *
     * @param val
     * @return
     */
    private static String shortToHexString(short val) {
        return Integer.toHexString(val & 0xffff);
    }
}
