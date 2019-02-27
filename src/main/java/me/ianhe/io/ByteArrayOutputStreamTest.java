package me.ianhe.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static me.ianhe.test.IOSupport.ARRAY_LETTERS;

/**
 * @author iHelin
 * @date 2019-01-30 15:31
 */
public class ByteArrayOutputStreamTest {

    public static void main(String[] args) {
        // 创建ByteArrayOutputStream字节流
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        // 依次写入“A”、“B”、“C”三个字母。0x41对应A，0x42对应B，0x43对应C。
        byteArrayOutputStream.write(0x41);
        byteArrayOutputStream.write(0x42);
        byteArrayOutputStream.write(0x43);
        System.out.printf("byteArrayOutputStream = %s\n", byteArrayOutputStream);

        // 将ArrayLetters数组中从“3”开始的后5个字节写入到baos中。
        // 即对应写入“0x64, 0x65, 0x66, 0x67, 0x68”，即“defgh”
        byteArrayOutputStream.write(ARRAY_LETTERS, 3, 5);
        System.out.printf("byteArrayOutputStream = %s\n", byteArrayOutputStream);

        // 计算长度
        int size = byteArrayOutputStream.size();
        System.out.printf("size = %s\n", size);

        // 转换成byte[]数组
        byte[] buf = byteArrayOutputStream.toByteArray();
        String str = new String(buf);
        System.out.printf("str = %s\n", str);

        // 将byteArrayOutputStream写入到另一个输出流中
        try {
            ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream();
            byteArrayOutputStream.writeTo(byteArrayOutputStream1);
            System.out.printf("byteArrayOutputStream1 = %s\n", byteArrayOutputStream1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
