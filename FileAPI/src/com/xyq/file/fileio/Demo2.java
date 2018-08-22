package com.xyq.file.fileio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo2 {
	public static void main(String[] args) throws IOException {
		//1、确定字符串
		String str = "hello 世界";
		
		//2、确定目标文件
		File file = new File("F:\\CloudMusic\\b.txt");
		
		//3、建立连接
		FileOutputStream fos = new FileOutputStream(file);
		
		//4、写出字符串
		byte[] bytes = str.getBytes();
		fos.write(bytes);
		
		//5、关闭流
		fos.close();
	}

}
