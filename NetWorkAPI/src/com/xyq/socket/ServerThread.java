package com.xyq.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServerThread implements Runnable {

	Socket s;
	public ServerThread(Socket s) {
		this.s = s;
	}
	
	@Override
	public void run() {
		InputStream is = null;
		ObjectInputStream dis = null;
		OutputStream os = null;
		DataOutputStream dos = null;
		try {
			is = s.getInputStream();
			dis = new ObjectInputStream(is);
			Object o = dis.readObject();
			User u = (User) o;
			
			s.shutdownInput();
			os = s.getOutputStream();
			dos = new DataOutputStream(os);
			if("z3".equals(u.getName()) && "123456".equals(u.getPassword())) {
				dos.writeUTF("登录成功!");
			}else {
				dos.writeUTF("登录失败!");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			dos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			dis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
