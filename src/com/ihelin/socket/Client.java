package com.ihelin.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	
	public static void main(String[] args) {
		try {
			Socket so = new Socket("127.0.0.1", 8888);
			OutputStream os = so.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.write("Hello");
			pw.flush();
			so.shutdownOutput();
			os.close();
			pw.close();
			so.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
