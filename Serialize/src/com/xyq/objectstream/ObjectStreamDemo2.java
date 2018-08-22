package com.xyq.objectstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectStreamDemo2 {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream oos = new ObjectInputStream(new FileInputStream(new File("f:/CloudMusic/demo2.txt")));
		
		Student stu = (Student)oos.readObject();
		System.out.println(stu);
	}

}
