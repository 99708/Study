package com.xyq.file.fileio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Demo1 {
	public static void main(String[] args) {
		//1、确定源文件
		File file = new File("F:\\CloudMusic\\a.txt");
		
		//2、建立连接
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//3、读入源文件
		int n = 0;
		try {
			n = fis.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(n == -1) {
			System.out.println("文件为空");
		}
		
		while(n != -1) {
			System.out.println((char)n);
			try {
				n = fis.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//4、关闭连接
		try {
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
