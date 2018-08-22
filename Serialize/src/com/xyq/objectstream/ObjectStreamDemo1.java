package com.xyq.objectstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectStreamDemo1 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("f:/CloudMusic/demo2.txt")));
		
		Student stu = new Student("z3", 18, "123456");
		Student.setA(10);
		oos.writeObject(stu);
		
		oos.close();
	}

}
