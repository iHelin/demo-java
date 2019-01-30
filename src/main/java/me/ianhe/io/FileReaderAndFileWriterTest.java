package me.ianhe.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author iHelin
 * @since 2017/8/12 10:48
 */
public class FileReaderAndFileWriterTest {

    /**
     * @author iHelin
     * @since 2017/11/29 14:49
     */
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("demo/read.txt");
        FileWriter fileWriter = new FileWriter("demo/fileWriter.txt");
        //一次循环读2K大小
        char[] buffer = new char[2048];
        int numberRead;
        while ((numberRead = fileReader.read(buffer)) != -1) {
            fileWriter.write(buffer, 0, numberRead);
            fileWriter.flush();
        }
        fileWriter.close();
        fileReader.close();
    }
}
