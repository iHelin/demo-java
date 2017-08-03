package me.ianhe.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FrAndFwDemo {

	public static void main(String[] args) throws IOException{
		FileReader fr = new FileReader("demo/1.txt");
		FileWriter fw = new FileWriter("demo/2.txt");
		char[] buffer = new char[2056];
		int c;
		while((c = fr.read(buffer, 0, buffer.length))!=-1){
			fw.write(buffer,0,c);
			fw.flush();
		}
		fw.close();
		fr.close();

	}

}
