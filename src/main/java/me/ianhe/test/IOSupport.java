package me.ianhe.test;

import java.io.*;

/**
 * @author iHelin
 * @date 2019-02-27 11:20
 */
public class IOSupport {


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
