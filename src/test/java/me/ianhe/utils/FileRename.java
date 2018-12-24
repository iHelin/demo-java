package me.ianhe.utils;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author iHelin
 * @date 2018/11/5 21:24
 */
public class FileRename {

    public static void main(String[] args) throws IOException {
        File dir = new File("/Users/iHelin/Music/网易云音乐");
//        File dir = new File("/Volumes/HL(1G)/我的音乐");
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (!FilenameUtils.isExtension(file.getName(), "mp3")) {
                    System.out.println(FilenameUtils.getBaseName(file.getName()));
//                    FilenameUtils.directoryContains();
                    System.out.println(file.getName());
                }
            }
        }
    }
}
