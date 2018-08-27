package com.xyq.socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer02{
	public static void main(String[] args) throws IOException {
		System.out.println("服务端启动了");
		ServerSocket ss = new ServerSocket(8080);
		Socket s = ss.accept();
		InputStream is = s.getInputStream();
		BufferedInputStream bis = new BufferedInputStream(is);
		
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("D:\\abc.bmp")));
		
		byte[] b = new byte[1024];
		int len = bis.read(b);
		while(len != -1) {
			bos.write(b, 0, len);
			len = bis.read(b);
		}
		
		s.shutdownInput();
		OutputStream os = s.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		dos.writeUTF("图片上传成功");
		
		dos.close();
		os.close();
		bis.close();
		bos.close();
		is.close();
		s.close();
		ss.close();
	}
}
