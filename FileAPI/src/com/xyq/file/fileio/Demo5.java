package com.xyq.file.fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo5 {
	public static void main(String[] args) throws IOException {
		File f1 = new File("f:/CloudMusic/a.txt");
		File f2 = new File("f:/CloudMusic/b.txt");
		
		FileReader fr = new FileReader(f1);
		FileWriter fw = new FileWriter(f2);
		
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(fw);
		
//		char[] ch = new char[4];
//		int len = br.read(ch);
//		while(len != -1) {
//			bw.write(ch, 0, len);
//			br.read(ch);
//		}
		
		String str = br.readLine();
		
		while(str != null) {
			bw.write(str);
			bw.newLine();
			str = br.readLine();
		}
		
		bw.close();
		br.close();
		
	}

}
