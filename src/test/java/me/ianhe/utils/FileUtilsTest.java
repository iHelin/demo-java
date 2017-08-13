package me.ianhe.utils;

import org.junit.Test;

import java.io.File;

/**
 * @author iHelin
 * @since 2017/8/3 15:23
 */
public class FileUtilsTest {
    @Test
    public void listDirectory() throws Exception {
        FileUtils.listDirectory(new File("/Users/iHelin/Music/网易云音乐"));
    }

}