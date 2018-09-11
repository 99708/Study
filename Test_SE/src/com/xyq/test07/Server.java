package com.xyq.test07;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		ServerSocket ss = null;
		BufferedOutputStream bos = null; 
		
		try {
			ss = new ServerSocket(8888);
			Socket s = ss.accept();
			InputStream is = s.getInputStream();
			byte[] b = new byte[1024];
			int len = is.read(b);
			File f = new File("d:/sxt2/b.txt");
			FileOutputStream fos = new FileOutputStream(f);
			bos = new BufferedOutputStream(fos);
			while(len != -1) {
				bos.write(b, 0, len);
				len = is.read();
			}
			System.out.println("上传成功");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
			try {
				bos.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			try {
				ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
