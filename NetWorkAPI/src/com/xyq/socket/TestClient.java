package com.xyq.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TestClient {
	public static void main(String[] args)  {
		System.out.println("客户端启动了");
		Socket socket = null;
		OutputStream os = null;
		ObjectOutputStream dos = null;
		InputStream is = null;
		DataInputStream dis = null;
		try {
			socket = new Socket("localhost",8080);
			
			os = socket.getOutputStream();
			
			Scanner sc = new Scanner(System.in);
			System.out.print("账号：");
			String name = sc.next();
			System.out.print("密码：");
			String passworld = sc.next();
			
			User u = new User(name, passworld);
			
			dos = new ObjectOutputStream(os);
			dos.writeObject(u);
			
			socket.shutdownOutput();
			is = socket.getInputStream();
			dis = new DataInputStream(is);
			String str = dis.readUTF();
			System.out.println(str);
		} catch (UnknownHostException e) {
			e.printStackTrace();
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
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
