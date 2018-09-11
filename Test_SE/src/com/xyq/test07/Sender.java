package com.xyq.test07;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Sender {
	public static void main(String[] args) {
		
		Socket s = null;
		FileInputStream fs = null;
		
		try {
			File f = new File("d:/sxt/a.txt");
			fs = new FileInputStream(f);
			byte[] b = new byte[1024];
			int len = fs.read(b);
			
			s = new Socket("localhost", 8888);
			OutputStream os = s.getOutputStream();
			
			while(len != -1) {
				os.write(b, 0, len);
				len = fs.read(b);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
			try {
				fs.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			try {
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
