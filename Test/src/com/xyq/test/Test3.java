package com.xyq.test;

import java.util.ArrayList;
import java.util.Collections;

public class Test3 {
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
	
		list.add(15);
		list.add(52);
		list.add(23);
		list.add(15);
		
		System.out.println(list);
		
		Collections.addAll(list, 24);
		System.out.println(list);
		
		Collections.sort(list);
		System.out.println(list);
		
		
		System.out.println(Collections.binarySearch(list, 15));
		System.out.println(Collections.binarySearch(list, 5));
		System.out.println(Collections.binarySearch(list, 52));
		
	}

}
