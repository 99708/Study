package com.xyq.collection.list;

import java.util.ArrayList;

public class Test2 {
	public static void main(String[] args) {
		ArrayList<Number> list = new ArrayList<Number>();
		list.add(5);
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(4);
//		ArrayList<String> list3 = new ArrayList<String>();
//		list3.add("java");
		add(list);
		add(list2);
//		add(list3);
	}
	//泛型上限(下限为 ？ super Number)
	public static int add(ArrayList<? extends Number> list) {
		return 0;
	}
}
