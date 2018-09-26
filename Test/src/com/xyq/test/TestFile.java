package com.xyq.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class TestFile {
	public static void main(String[] args) {
		File file = new File("F:/CloudMusic/Test/周杰伦 - 七里香.mp3");
		System.out.println(file);
		if(!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			System.out.println(file);
			System.out.println(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
