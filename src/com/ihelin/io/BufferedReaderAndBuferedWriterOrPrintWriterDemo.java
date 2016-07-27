package com.ihelin.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class BufferedReaderAndBuferedWriterOrPrintWriterDemo {
	/**
	 * 将1.txt中的内容复制到4.txt中
	 * 
	 */
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("demo/1.txt")));
		FileInputStream fis = new FileInputStream("demo/1.txt");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new
		// FileOutputStream("demo/3.txt")));
		PrintWriter pw = new PrintWriter("demo/4.txt");
		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line);// 一次读一行，并不能识别
			/*
			 * bw.write(line); //单独写换行操作 bw.newLine();//换行操作 bw.flush();
			 */
			pw.println(line);
			pw.flush();
		}
		br.close();
		// bw.close();
		pw.close();
	}

}
