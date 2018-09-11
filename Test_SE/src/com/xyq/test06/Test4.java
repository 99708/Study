package com.xyq.test06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test4 {
	public static void main(String[] args) throws IOException {
		File file = new File("d:/sxtjava");
		File file2 = new File("d:/sxtjava2");
		Test4 test4 = new Test4();
		test4.copyFiles(file, file2);
		test4.showName(file, 0);
		System.out.println("==================================================");
		test4.showName(file2, 0);
	}
	
	public void copyFiles(File file, File file2) throws IOException {
		
		if(!file2.exists()) {
			file2.mkdir();
		}
		
		File[] fs = file.listFiles();
		for(File f:fs) {
			if(f.isDirectory()) {
				copyFiles(new File(file + "/" + f.getName()), new File(file2 + "/" + f.getName()));
			}else {
				copyFile(new File(file + "/" + f.getName()), new File(file2 + "/" + f.getName()));
			}
		}
		
	}
	
	public void copyFile(File file, File file2) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file2));
		
		byte[] bytes = new byte[1024];
		int len = bis.read(bytes);
		while(len != -1) {
			bos.write(bytes, 0, len);
			len = bis.read(bytes);
		}
		
		bis.close();
		bos.close();
	}
	
	public void showName(File file, int level) {
		File[] fs = file.listFiles();
		for(File f:fs) {
			for(int i=0; i<level; i++) {
				System.out.print("|--");
			}
			if(f.isDirectory()) {
				System.out.println(f.getName());
				showName(f, level+1);
			}else {
				System.out.println(f.getName());
			}
		}
	}
}
