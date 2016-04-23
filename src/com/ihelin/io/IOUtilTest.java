package com.ihelin.io;

import java.io.File;
import java.io.IOException;

public class IOUtilTest {

	public static void main(String[] args) throws IOException {
		//IOUtil.copyFile(new File("e:\\ali.png"), new File("e:\\wangyi.png"));
		//IOUtil.printHex("/Users/ihelin/test/123.docx");
		//IOUtil.printHexByByteArray("/Users/ihelin/test/123.docx");
		//IOUtil.copyFileByBuffered(new File("/Users/ihelin/test/123.docx"), new File("/Users/ihelin/test/321.docx"));
		//IOUtil.copyFile(new File("/Users/ihelin/test/123.docx"), new File("/Users/ihelin/test/321.docx"));
		IOUtil.copyFileByByte(new File("/Users/ihelin/test/123.docx"), new File("/Users/ihelin/test/321.docx"));

	}

}
