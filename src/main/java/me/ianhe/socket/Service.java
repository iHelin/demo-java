package me.ianhe.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Service {
	
	public static void main(String[] args) {
		try {
			ServerSocket serversocket = new ServerSocket(8888);
			System.out.println("等待客户端连接中...");
			Socket socket = serversocket.accept();
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String info = null;
			while((info=br.readLine())!=null){
				System.out.println(info);
			}
			socket.shutdownInput();
			is.close();
			isr.close();
			br.close();
			serversocket.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
