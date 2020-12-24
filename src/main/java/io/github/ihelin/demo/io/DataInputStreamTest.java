package io.github.ihelin.demo.io;

import io.github.ihelin.demo.utils.IOSupport;

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
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream("demo/data.txt"));
            System.out.printf("byteToHexString(0x8F):0x%s\n", IOSupport.byteToHexString((byte) 0x8F));
            System.out.printf("charToHexString(0x8FCF):0x%s\n", IOSupport.charToHexString((char) 0x8FCF));
            System.out.printf("readBoolean():%s\n", dataInputStream.readBoolean());
            System.out.printf("readByte():0x%s\n", IOSupport.byteToHexString(dataInputStream.readByte()));
            System.out.printf("readChar():0x%s\n", IOSupport.charToHexString(dataInputStream.readChar()));
            System.out.printf("readShort():0x%s\n", IOSupport.shortToHexString(dataInputStream.readShort()));
            System.out.printf("readInt():0x%s\n", Integer.toHexString(dataInputStream.readInt()));
            System.out.printf("readLong():0x%s\n", Long.toHexString(dataInputStream.readLong()));
            System.out.printf("readUTF():%s\n", dataInputStream.readUTF());
            dataInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
