package me.ianhe.io;

import me.ianhe.utils.IOUtil;
import org.junit.Test;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

/**
 * @author iHelin
 * @since 2017/8/3 15:00
 */
public class DataOutputStreamTest {

    @Test
    public void test() throws Exception {
        String file = "demo/DataOutputStreamTest.txt";
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
        dos.writeInt(10);
        dos.writeInt(-10);
        dos.writeLong(10L);
        dos.writeDouble(10.5);
        //采用utf-8编码写出
        dos.writeUTF("中国");
        //采用utf-16be写出
        dos.writeChars("中国");
        dos.close();
        IOUtil.printHex(file);
    }

}