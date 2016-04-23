package com.ihelin.io;

import java.io.File;
import java.io.IOException;

/**
 * java.io.File类用于表示文件（目录）
 * File类只用于表示文件（目录）的信息（名称、大小等），不能用于文件内容的访问
 * @author ihelin
 *
 */
public class FileDemo {
	
	public static void main(String[] args) {
		//了解构造函数的情况 查帮助
		File file = new File("/Users/ihelin/test/ihelin");
		//System.out.println(file.exists());
		if(!file.exists())
			file.mkdirs();
		else
			file.delete();
		//是否是一个目录 是目录返回true，不是目录or目录不存在返回false
		System.out.println(file.isDirectory());
		//是否是一个文件
		System.out.println(file.isFile());
		
		//File file2 = new File("/Users/ihelin/test/1.txt");
		File file2 = new File("/Users/ihelin/test", "1.txt");
		if(!file2.exists())
			try {
				file2.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		else
			file2.delete();
		//File类常用API
		System.out.println(file);//file.toString()的内容
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getName());
		System.out.println(file2.getName());
		System.out.println(file.getParent());
	}

}
