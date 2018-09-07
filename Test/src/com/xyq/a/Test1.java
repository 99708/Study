package com.xyq.a;

import java.util.ArrayList;

public class Test1 {
	public static ArrayList<Integer> lists = new ArrayList<Integer>();
	
	public void add(int a) {
		lists.add(a);
	}
	
	public ArrayList<Integer> getList() {
		return lists;
	}
}
