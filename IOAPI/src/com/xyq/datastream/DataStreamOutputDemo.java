package com.xyq.datastream;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamOutputDemo {
	public static void main(String[] args) throws IOException {
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File("f:/CloudMusic/test2.txt")));
		
		dos.writeInt(12);
		dos.writeUTF("java");
		dos.writeDouble(12.5);
		dos.writeBoolean(false);
		
		dos.close();
	}

}
