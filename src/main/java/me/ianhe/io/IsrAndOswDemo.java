package me.ianhe.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class IsrAndOswDemo {

	public static void main(String[] args) throws IOException {
		FileInputStream in = new FileInputStream("/Users/ihelin/test/123.docx");
		InputStreamReader isr = new InputStreamReader(in);
		int c;
		while((c = isr.read())!=-1){
			System.out.println((char)c);
		}
		
		isr.close();
	}
}
