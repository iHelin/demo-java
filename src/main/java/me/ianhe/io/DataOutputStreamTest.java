package me.ianhe.io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author iHelin
 * @date 2019-01-30 15:38
 */
public class DataOutputStreamTest {

    public static void main(String[] args) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(
                    new FileOutputStream("demo/data.txt"));
            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeByte((byte) 0x41);
            dataOutputStream.writeChar((char) 0x4243);
            dataOutputStream.writeShort((short) 0x4445);
            dataOutputStream.writeInt(0x12345678);
            dataOutputStream.writeLong(0x0FEDCBA987654321L);
            dataOutputStream.writeUTF("abcdefghijklmnopqrstuvwxyz何12");
            dataOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
