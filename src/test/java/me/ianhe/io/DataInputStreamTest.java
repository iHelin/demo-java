package me.ianhe.io;

import me.ianhe.utils.IOUtil;
import org.junit.Test;

import java.io.DataInputStream;
import java.io.FileInputStream;

/**
 * @author iHelin
 * @since 2017/8/3 14:53
 */
public class DataInputStreamTest {

    @Test
    public void test() throws Exception {
        String file = "demo/DataOutputStream.txt";
        IOUtil.printHex(file);
        System.out.println("-----------");
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
        int i = dataInputStream.readInt();
        System.out.println(i);
        i = dataInputStream.readInt();
        System.out.println(i);
        long l = dataInputStream.readLong();
        System.out.println(l);
        double d = dataInputStream.readDouble();
        System.out.println(d);
        String s = dataInputStream.readUTF();
        System.out.println(s);
        dataInputStream.close();
    }

}