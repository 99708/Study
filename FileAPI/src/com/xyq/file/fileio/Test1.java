package com.xyq.file.fileio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test1 {
	public static void main(String[] args) throws IOException {
		File file = new File("F:\\CloudMusic\\a.txt");
		FileInputStream fis = new FileInputStream(file);
		
		File file2 = new File("F:\\CloudMusic\\e.txt");
		FileOutputStream fos = new FileOutputStream(file2);
		
		int n = 0;
		while(n!=-1) {
			n = fis.read();
			fos.write(n);
		}
		
		fos.close();
		fis.close();
		
	}

}
