package me.ianhe.utils;

import org.junit.Test;

import java.io.File;

/**
 * @author iHelin
 * @since 2017/8/3 15:27
 */
public class IOUtilTest {
    @Test
    public void printHex() throws Exception {

    }

    @Test
    public void printHexByByteArray() throws Exception {
    }

    @Test
    public void copyFile() throws Exception {
        IOUtil.copyFileByByte(new File("/Users/iHelin/Documents/IdeaProjects/hello/demo/PrintWriter.txt"),
                new File("/Users/iHelin/Documents/IdeaProjects/hello/demo/test/PrintWriter.txt"));
    }

    @Test
    public void copyFileByBuffered() throws Exception {
    }

    @Test
    public void copyFileByByte() throws Exception {
    }

}