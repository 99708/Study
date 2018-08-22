package com.xyq.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class Deml1 {
	public static void main(String[] args) throws IOException {
		InputStream in = System.in;
		int len = in.read();
//		System.out.println(len);
		
		PrintStream out = System.out;
		out.println("aaa");
		out.println(23);
		
		
		
		
	}

}
