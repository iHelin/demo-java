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
        String file = "demo/DataOutputStream.txt";
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
        dataOutputStream.writeInt(10);
        dataOutputStream.writeInt(-10);
        dataOutputStream.writeLong(10L);
        dataOutputStream.writeDouble(10.5);
        //采用utf-8编码写出
        dataOutputStream.writeUTF("中国");
        //采用utf-16be写出
//        dos.writeChars("中国");
        dataOutputStream.close();
        IOUtil.printHex(file);
    }

}