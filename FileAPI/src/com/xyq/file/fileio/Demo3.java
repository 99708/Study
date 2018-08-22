package com.xyq.file.fileio;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo3 {
	
	public static void main(String[] args) throws IOException {
		
		File f1 = new File("f:/CloudMusic/a.txt");
		FileReader fr = new FileReader(f1);
		File f2 = new File("f:/CloudMusic/d.txt");
		FileWriter fw = new FileWriter(f2);
		
		char[] c = new char[4];
		int len = fr.read(c);
		while(len != -1) {
			fw.write(c, 0, len);
			len = fr.read(c);
		}
		
		fw.close();
		fr.close();
	}

}
