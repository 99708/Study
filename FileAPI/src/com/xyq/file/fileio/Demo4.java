package com.xyq.file.fileio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo4 {
	public static void main(String[] args) {
		
		File f1 = new File("f:/CloudMusic/a.txt");
		File f2 = new File("f:/CloudMusic/b.txt");
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			fis = new FileInputStream(f1);
			fos = new FileOutputStream(f2);
			
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			byte[] bytes = new byte[8];
			int len = bis.read(bytes);
			while(len != -1) {
				bos.write(bytes, 0, len);
				len = bis.read(bytes);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
