package com.xyq.collection.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class TestHashtable {
	public static void main(String[] args) {
		
//		Map<Integer, String> map = new Hashtable<Integer, String>();
//		
//		map.put(null, "l4");
//		map.put(1005, "w5");
//		map.put(null, "z3");
//		map.put(1001, null);
//		
//		System.out.println(map);
//		System.out.println(map.size());
		
		Map<Integer, String> map2 = new HashMap<Integer, String>();
		
		map2.put(null, "l4");
		map2.put(1005, "w5");
		map2.put(null, "z3");
		map2.put(1001, null);
		
		System.out.println(map2);
		System.out.println(map2.size());
		
	}
}
