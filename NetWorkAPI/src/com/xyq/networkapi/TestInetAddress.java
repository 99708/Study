package com.xyq.networkapi;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class TestInetAddress {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress ia = InetAddress.getByName("localhost");
		System.out.println(ia);
		System.out.println(ia.getHostName());
		System.out.println(ia.getHostAddress());
		
		
		InetAddress ia2 = InetAddress.getByName("192.168.143.16");
		System.out.println(ia2);
		System.out.println(ia2.getHostName());
		System.out.println(ia2.getHostAddress());
		
		InetSocketAddress isa = new InetSocketAddress("localhost", 8080);
		System.out.println(isa);
		System.out.println(isa.getHostName());
		System.out.println(isa.getPort());
		
	}
}
