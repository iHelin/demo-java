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
        DataInputStream dis = new DataInputStream(new FileInputStream(file));
        int i = dis.readInt();
        System.out.println(i);
        i = dis.readInt();
        System.out.println(i);
        long l = dis.readLong();
        System.out.println(l);
        double d = dis.readDouble();
        System.out.println(d);
        String s = dis.readUTF();
        System.out.println(s);
        dis.close();
    }

}