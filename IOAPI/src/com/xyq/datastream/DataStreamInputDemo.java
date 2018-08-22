package com.xyq.datastream;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DataStreamInputDemo {
	public static void main(String[] args) throws IOException {
		DataInputStream dis = new DataInputStream(new FileInputStream(new File("f:/CloudMusic/test2.txt")));
		
		System.out.println(dis.readInt());
		System.out.println(dis.readUTF());
		System.out.println(dis.readDouble());
		System.out.println(dis.readBoolean());
		
		dis.close();
		
	}

}
