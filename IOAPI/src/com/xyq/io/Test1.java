package com.xyq.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test1 {
	public static void main(String[] args) throws IOException {
		//接收键盘录入
		System.out.println("请输入你要写入的字符");
		InputStream in = System.in;
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);
		//
		File file = new File("f:/CloudMusic/test.txt");
		FileWriter fw = new FileWriter(file);
		BufferedWriter bf = new BufferedWriter(fw);
		
		String str = br.readLine();
		while(str != null) {
			bf.write(str);
			bf.newLine();
			if(" ".equals(str)) {
				break;
			}
			str = br.readLine();
		}
		
		bf.close();
		br.close();
	}

}
