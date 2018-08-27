package com.xyq.test;

import java.util.ArrayList;
import java.util.List;

public class Test6 {
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		list.add("str1");
		list.add(2, "str2");
		String s=list.get(1);
		System.out.println(s);
	}

}
