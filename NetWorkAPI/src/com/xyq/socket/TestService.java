package com.xyq.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TestService {
	public static void main(String[] args) {
		System.out.println("服务端启动了");
		Socket s = null;
		int count = 1;
		try {
			ServerSocket ss = new ServerSocket(8080);
			while(true) {
				s = ss.accept();
				new Thread(new ServerThread(s)).start();
				System.out.println("第"+(count++)+"个访问者，访问IP是：" + s.getInetAddress());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
