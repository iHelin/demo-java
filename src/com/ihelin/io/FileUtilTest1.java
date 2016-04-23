package com.ihelin.io;

import java.io.File;
import java.io.IOException;

public class FileUtilTest1 {
	
	public static void main(String[] args) throws IOException {
		FileUtils.listDirectory(new File("/Users/ihelin/git/iHelin"));
	}

}
