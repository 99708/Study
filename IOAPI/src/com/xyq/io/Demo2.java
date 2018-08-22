package com.xyq.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo2 {
	public static void main(String[] args) throws IOException {
		File src = new File("f:/CloudMusic");
		File ter = new File("f:/Test");
		copyFiles(src, ter);
	}
	
	
	public static void copyFiles(File src, File ter) throws IOException {
		
		if(!ter.exists()) {
			ter.mkdir();
		}
		File[] fs = src.listFiles();
		for(File f:fs) {
			if(f.isDirectory()) {
				copyFiles(new File(src +"/" + f.getName()), new File(ter +"/" + f.getName()));
			}else {
				copyFile(new File(src +"/" + f.getName()), new File(ter +"/" + f.getName()));
			}
		}
		
	}
	
	public static void copyFile(File src, File ter) throws IOException {
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(ter));
		
		byte[] bytes = new byte[1024];
		int len = bis.read(bytes);
		while(len != -1) {
			bos.write(bytes, 0, len);
			len = bis.read(bytes);
		}
		
		bos.close();
		bis.close();
		
	}
}
