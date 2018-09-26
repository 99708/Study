package com.xyq.daoImp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadDaoImpl {
	
	public static void main(String[] args) {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		ServerSocket ss = null;
	
			try {
				ss = new ServerSocket(8888);
				while(true) {
					Socket s = ss.accept();
					DataInputStream dis = new DataInputStream(s.getInputStream());
					String servicePath = dis.readUTF();
					System.out.println(servicePath);
					File file = new File(servicePath);
					if(!file.getParentFile().exists()) {
						file.getParentFile().mkdirs();
					}
					bis = new BufferedInputStream(s.getInputStream());
					bos = new BufferedOutputStream(new FileOutputStream(file));
					DataOutputStream dos = new DataOutputStream(s.getOutputStream());
					
					byte[] b = new byte[1024];
					int len = bis.read(b);
					while(len > -1) {
						bos.write(b, 0 , len);
						len = bis.read(b);
					}
					s.shutdownInput();
					dos.writeUTF("上传成功");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					ss.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		
	}

}
