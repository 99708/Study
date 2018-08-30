package com.xyq.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Receiver {
	public static void main(String[] args)  {
		
		DatagramSocket ds = null;
		Scanner sc = new Scanner(System.in);
		try {
			ds = new DatagramSocket(8080);
			while(true) {
				
				byte[] b = new byte[1024];
				
				DatagramPacket dp = new DatagramPacket(b, b.length);
				ds.receive(dp);
				
				String str = new String(dp.getData(), 0, dp.getLength());
				
				System.out.println("学生对我说：" + str);
				if("goodbyte".equals(str)) {
					System.out.println("学生下线了。。。。。,老师也下线了。。。。");
					break;
				}
				System.out.print("老师对学生说：");
				String str2 = sc.next();
				
				DatagramPacket dp2 = new DatagramPacket(str2.getBytes(), str2.getBytes().length, InetAddress.getByName("localhost"), 8088);
				
				ds.send(dp2);
		
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
