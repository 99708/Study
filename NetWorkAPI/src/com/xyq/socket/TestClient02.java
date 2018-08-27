package com.xyq.socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestClient02{
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		System.out.println("客户端启动了");
		Socket socket = new Socket("localhost", 8080);
		
		OutputStream os = socket.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(os);
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\Dell\\Desktop\\123.bmp")));
		
		byte[] b = new byte[1024];
		int len = bis.read(b);
		while(len != -1) {
			bos.write(b, 0, len);
			len = bis.read(b);
		}
		
		socket.shutdownOutput();
		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		String str = dis.readUTF();
		System.out.println("客户端收到服务端响应的消息：" + str);
		
		
		dis.close();
		is.close();
		bis.close();
//		bos.close();
		os.close();
		socket.close();
		
	}
}
