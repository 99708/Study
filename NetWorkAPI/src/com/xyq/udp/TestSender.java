package com.xyq.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TestSender {
	public static void main(String[] args) {
		DatagramSocket ds = null;
		Scanner sc = new Scanner(System.in);
		try {
			ds = new DatagramSocket(8088);
			while(true) {
				
				System.out.print("我对老师说：");
				
				String str = sc.next();
				
				DatagramPacket dp = new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName("localhost"), 8080);
				
				ds.send(dp);
				if("goodbyte".equals(str)) {
					System.out.println("学生下线了。。。。。");
					break;
				}
				byte[] b = new byte[1024];
				
				DatagramPacket dp2 = new DatagramPacket(b, b.length);
				ds.receive(dp2);
				
				String str2 = new String(dp2.getData(), 0, dp2.getLength());
				
				System.out.println("老师对我说：" +str2);
			}
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			ds.close();
		}
		
	}
}
