package com.xyq.file;

import java.io.File;
import java.io.IOException;

public class Demo1 {
	public static void main(String[] args) {
//		File file = new File("E:\\Test\\a.txt");
		File file = new File("a.txt");
		
//		System.out.println(file);
//		
//		System.out.println(file.isDirectory());
//		System.out.println(file.isFile());
//		
		
		if(file.exists()) {
			file.delete();
		}else {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getPath());
		System.out.println(file);
	}
	
}
