package com.xyq.file;

import java.io.File;

public class Demo2 {
	public static void main(String[] args) {
		File file = new File("F:\\CloudMusic");
		showName(file, 1);
	}
	
	public static void showName(File file, int level) {
		File[] files = file.listFiles();
		
		for(File f:files) {
			for(int i=1; i<level; i++) {
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
