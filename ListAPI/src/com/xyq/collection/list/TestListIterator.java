package com.xyq.collection.list;

import java.util.ArrayList;
import java.util.ListIterator;

public class TestListIterator {
	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
		
		
		ListIterator<String> it = list.listIterator();
		while(it.hasNext()) {
			if("ccc".equals(it.next())) {
				it.add("aaa");
			}
		}
		System.out.println(list);
		
		System.out.println(it.hasNext());
		System.out.println(it.hasPrevious());
		
		
		while(it.hasPrevious()) {
			System.out.print(it.previous()+"\t");
		}
	}

}
