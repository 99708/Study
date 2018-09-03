package com.xyq.test;

import java.util.ArrayList;
import java.util.List;

public class Test8 {
	public Test8() {
	}
	static void print(List<Integer> al) {
		al.add(2);
		System.out.println("================");
		System.out.println(al);
		al = new ArrayList<Integer>();
		al.add(3);
		al.add(4);
		System.out.println("#################");
		System.out.println(al);
	}
	public static void main(String[] args) {
		List<Integer> al = new ArrayList<Integer>();
		al.add(1);
		print(al);
		System.out.println("----------------------");
		System.out.println(al);
		System.out.println(al.get(1));
		
	}
}

