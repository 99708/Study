package com.xyq.file.fileio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test2 {
	public static void main(String[] args) throws IOException {
		File file = new File("F:\\CloudMusic\\a.txt");
		FileInputStream fis = new FileInputStream(file);
		
		File file2 = new File("F:\\CloudMusic\\e.txt");
		FileOutputStream fos = new FileOutputStream(file2);
		
		byte[] bytes = new byte[8];
		int len = fis.read(bytes);
		while(len != -1) {
			fos.write(bytes, 0, len);
			len = fis.read(bytes);
		}
		
		fos.close();
		fis.close();
	}

}
